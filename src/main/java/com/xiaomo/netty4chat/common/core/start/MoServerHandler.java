package com.xiaomo.netty4chat.common.core.start;

import com.xiaomo.netty4chat.common.core.annotation.Invoker;
import com.xiaomo.netty4chat.common.core.annotation.InvokerHolder;
import com.xiaomo.netty4chat.common.core.codec.MoChannel;
import com.xiaomo.netty4chat.common.core.codec.MoRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 服务端处理器实现类
 */
public class MoServerHandler extends AbstractMoServerHandler {

    @Override
    public void moChannelInactive(MoChannel moChannel,ChannelHandlerContext ctx) throws Exception {

        RequestHandler requestHandler = new RequestHandler(moChannel,null,ctx);
        ResponseHandler responseHandler = new ResponseHandler(moChannel,null,ctx);
        inactive(requestHandler,responseHandler);

    }

    @Override
    public void channelRead0(MoChannel moChannel, MoRequest moRequest, ChannelHandlerContext channelHandlerContext) throws Exception {

        RequestHandler requestHandler = new RequestHandler(moChannel,moRequest,channelHandlerContext);
        ResponseHandler responseHandler = new ResponseHandler(moChannel,null,channelHandlerContext);
        service(requestHandler,responseHandler);

    }

    public void service(RequestHandler requestHandler,ResponseHandler responseHandler){

       MoRequest request = requestHandler.getMoRequest();
       if(request != null){
           short module = request.getModule();
           short cmd = request.getCmd();
           Invoker invoker = InvokerHolder.getInvoker(module,cmd);
           if(invoker == null){
               System.out.println("找不到处理器，请求无法处理");
               return;
           }
           try{
               invoker.invoke(requestHandler,responseHandler);
           }catch (Exception e){
               e.printStackTrace();
               System.out.println("处理异常，异常原因-"+e.getMessage());
           }
       }else {
           System.out.println("找不到请求体，请求异常无法处理");
       }
    }

    public void inactive(RequestHandler requestHandler,ResponseHandler responseHandler){

        Invoker invoker = InvokerHolder.getConfigInvoker("InactiveHandler");
        if(invoker != null){
            try{
                invoker.invoke(requestHandler,responseHandler);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("处理异常，异常原因-"+e.getMessage());
            }
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        Channel channel = ctx.channel();
        System.out.println("MoServerHandler 捕获异常 - " + cause.getMessage());
        cause.printStackTrace();
        if(channel.isActive()){
            ctx.close();
        }

    }
}
