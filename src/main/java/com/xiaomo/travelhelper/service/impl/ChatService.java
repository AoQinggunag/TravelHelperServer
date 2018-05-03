package com.xiaomo.travelhelper.service.impl;

import com.google.common.collect.Lists;
import com.xiaomo.netty4chat.common.core.codec.MoRequest;
import com.xiaomo.netty4chat.common.core.start.*;
import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.commons.SessionManager;
import com.xiaomo.travelhelper.mapper.ChatPrivateMapper;
import com.xiaomo.travelhelper.mapper.UserMapper;
import com.xiaomo.travelhelper.pojo.ChatPrivate;
import com.xiaomo.travelhelper.pojo.User;
import com.xiaomo.travelhelper.pojo.dto.OnLineDTO;
import com.xiaomo.travelhelper.pojo.dto.PrivateChatRequestDTO;
import com.xiaomo.travelhelper.pojo.dto.PrivateChatResponseDTO;
import com.xiaomo.travelhelper.service.IChatService;
import io.netty.channel.ChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 聊天服务实现类
 */
@Service("chatService")
public class ChatService implements IChatService {

    @Autowired
    private ChatPrivateMapper privateMapper;
    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void nettyStart(){

        System.out.println("nettyStart");

        List<ChannelHandler> channelHandlerList = Lists.newArrayList();
        channelHandlerList.add(new MoServerHandler());
        MoServerStart moServerStart = new MoServerStart(8888,2048,channelHandlerList);
        moServerStart.serverStart();

    }



    @Override
    public void privateChat(RequestHandler requestHandler, ResponseHandler responseHandler) {

        MoRequest request = requestHandler.getMoRequest();
        int length = request.getLength();
        if(length > 0){
            byte[] data = request.getData();
            PrivateChatRequestDTO dto = new PrivateChatRequestDTO();
            dto = (PrivateChatRequestDTO) dto.readFromBytes(data);
            System.out.println("收到请求-" + dto);
            String targetAccount = dto.getTargetAccount();
            OnLineDTO onLine = SessionManager.getOnlineUser(targetAccount);
            if(onLine == null){ // 离线数据入库
                System.out.println("离线数据入库");
                ChatPrivate chatPrivate = new ChatPrivate();
                chatPrivate.setContent(dto.getContent());
                chatPrivate.setCreateTime(new Date(System.currentTimeMillis()));
                chatPrivate.setSendUserId(dto.getSendAccount());
                chatPrivate.setTargetUserId(dto.getTargetAccount());
                privateMapper.insert(chatPrivate);

            }else{ // 在线直接回写
                PrivateChatResponseDTO responseDTO = new PrivateChatResponseDTO();
                String sendUsername = userMapper.getUsernameByAccount(dto.getSendAccount());
                String targetUsername = userMapper.getUsernameByAccount(dto.getTargetAccount());
                String sendImg = userMapper.getImgByAccount(dto.getSendAccount());
                String targetImg = userMapper.getImgByAccount(dto.getTargetAccount());
                responseDTO.setContent(dto.getContent());
                responseDTO.setFromAccount(dto.getSendAccount());
                responseDTO.setToAccount(dto.getTargetAccount());
                responseDTO.setFromUsername(sendUsername);
                responseDTO.setToUsername(targetUsername);
                responseDTO.setFromImg(sendImg);
                responseDTO.setToImg(targetImg);
                responseDTO.setTime(new Date(System.currentTimeMillis()).toString());
                responseDTO.setModule((short)1);
                responseDTO.setCmd((short)1);
                responseDTO.setStatusCode((short)1);
                SessionManager.sendMessage(dto.getTargetAccount(),responseDTO);

                System.out.println("响应请求-" + responseDTO);

            }

            onlineSetting(null,dto.getSendAccount(),requestHandler);


        }

    }

    @Override
    public void publicChat(RequestHandler requestHandler, ResponseHandler responseHandler) {

    }

    @Override
    public void online(RequestHandler requestHandler, ResponseHandler responseHandler) {

        MoRequest request = requestHandler.getMoRequest();
        int length = request.getLength();
        if(length > 0){
            byte[] data = request.getData();
            // 序列化
            OnLineDTO onLineDTO = new OnLineDTO();
            onLineDTO = (OnLineDTO) onLineDTO.readFromBytes(data);
            // 在线设置
           onlineSetting(onLineDTO.getUsername(),onLineDTO.getAccount(),requestHandler);

        }

    }

    private void onlineSetting(String username,String account,RequestHandler requestHandler){

        if(SessionManager.getOnlineUser(account) == null){
            OnLineDTO onLineDTO = new OnLineDTO();
            onLineDTO.setAccount(account);
            if(username == null){
                username = userMapper.getUsernameByAccount(account);
            }
            onLineDTO.setUsername(username);
            requestHandler.getSession().setAttachment(onLineDTO);
            SessionManager.putSession(onLineDTO.getAccount(),requestHandler.getSession());

            System.out.println(onLineDTO.getUsername() +" 用户上线");
            System.out.println("当前线上用户数-" + SessionManager.getOnlineUsers().size());
        }

    }

    @Override
    public void inActive(RequestHandler requestHandler, ResponseHandler responseHandler) {

        OnLineDTO onLineDTO = (OnLineDTO) requestHandler.getSession().getAttachment();
        if(onLineDTO != null){
            SessionManager.removeSession(onLineDTO.getAccount());
        }

        System.out.println("当前线上用户数-" + SessionManager.getOnlineUsers().size());

    }

    @Transactional
    @Override
    public ResultMessage listAndDeleteByTargetAccount(String targetAccount) {
        List<PrivateChatResponseDTO> dtoList = Lists.newArrayList();
        List<ChatPrivate> resultList = privateMapper.listByTargetAccount(targetAccount);
        for(ChatPrivate result : resultList){
            String sendUsername = userMapper.getUsernameByAccount(result.getSendUserId());
            String targetUsername = userMapper.getUsernameByAccount(result.getTargetUserId());
            String sendImg = userMapper.getImgByAccount(result.getSendUserId());
            String targetImg = userMapper.getImgByAccount(result.getTargetUserId());
            PrivateChatResponseDTO dto = new PrivateChatResponseDTO();
            dto.setFromAccount(result.getSendUserId());
            dto.setFromUsername(sendUsername);
            dto.setToAccount(result.getTargetUserId());
            dto.setToUsername(targetUsername);
            dto.setContent(result.getContent());
            dto.setFromImg(sendImg);
            dto.setToImg(targetImg);
            dto.setTime(result.getCreateTime().toString());
            dtoList.add(dto);
        }
        privateMapper.deleteByTargetAccount(targetAccount);
        return ResultMessage.buildBySuccess("获取成功",dtoList);
    }
}
