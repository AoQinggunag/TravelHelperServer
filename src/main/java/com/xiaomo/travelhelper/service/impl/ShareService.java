package com.xiaomo.travelhelper.service.impl;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.mapper.CommentMapper;
import com.xiaomo.travelhelper.mapper.ShareMapper;
import com.xiaomo.travelhelper.pojo.Share;
import com.xiaomo.travelhelper.pojo.dto.ShareInfo;
import com.xiaomo.travelhelper.service.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分享服务类
 */
@Service("shareService")
public class ShareService implements IShareService{

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultMessage saveShare(Share share) {
        int result = shareMapper.insertSelective(share);
        if(result > 0){
            return ResultMessage.buildBySuccess("发送成功");
        }
        return ResultMessage.buildByFail("发送失败");
    }

    @Override
    public ResultMessage listShares() {

        List<ShareInfo> shareList = shareMapper.listShares();
        for(ShareInfo shareInfo : shareList){
            shareInfo.setCommentList(commentMapper.listByShareId(shareInfo.getId()));
        }
        return ResultMessage.buildBySuccess("获取成功",shareList);
    }

    @Override
    public ResultMessage listSharesByPage(Integer pageSize, Integer pageNo) {
        int startSize = pageSize * (pageNo-1);
        List<ShareInfo> shareList = shareMapper.listSharesByPage(startSize,pageSize);
        for(ShareInfo shareInfo : shareList){
            shareInfo.setCommentList(commentMapper.listByShareId(shareInfo.getId()));
        }
        return ResultMessage.buildBySuccess("获取成功",shareList);
    }
}
