package com.xiaomo.netty4chat.common.core.start;

import com.xiaomo.netty4chat.common.core.codec.MoChannel;
import com.xiaomo.netty4chat.common.core.codec.MoRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 服务端抽象处理器
 */
public abstract class AbstractMoServerHandler extends SimpleChannelInboundHandler<MoRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MoRequest moRequest) throws Exception {

        System.out.println("接收到请求：AbstractMoServerHandler - " + moRequest);

        Channel channel = channelHandlerContext.channel();
        MoChannel moChannel = new MoChannel(channel);
        channelRead0(moChannel,moRequest,channelHandlerContext);

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        Channel channel = ctx.channel();
        MoChannel moChannel = new MoChannel(channel);
        moChannelInactive(moChannel,ctx);
    }


    /**
     * 断开连接时回调，需要清除在线会话
     * @param ctx
     * @throws Exception
     */
    public abstract void moChannelInactive(MoChannel moChannel,ChannelHandlerContext ctx) throws Exception;

    /**
     * 通道读取信息时回调
     * @param moChannel
     * @param moRequest
     * @param channelHandlerContext
     * @throws Exception
     */
    public abstract void channelRead0(MoChannel moChannel,MoRequest moRequest,ChannelHandlerContext channelHandlerContext) throws Exception;

}
