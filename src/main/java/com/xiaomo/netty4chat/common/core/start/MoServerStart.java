package com.xiaomo.netty4chat.common.core.start;

import com.xiaomo.netty4chat.common.core.codec.MoRequestDecoder;
import com.xiaomo.netty4chat.common.core.codec.MoResponseEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.List;

/**
 * author: mojiale66@163.com
 * date:   2018/4/28
 * description: 服务端启动类
 */
public class MoServerStart {

    /**端口*/
    private int port = 8080;
    /**缓冲池队列大小*/
    private int bufSize = 2048;
    /**通道处理器*/
    private List<ChannelHandler> channelHandlerList;
    /**服务类*/
   private ServerBootstrap bootstrap = new ServerBootstrap();
    /**boss*/
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    /** worker*/
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public MoServerStart(int port, int bufSize, List<ChannelHandler> channelHandlerList){
        this.port = port;
        this.bufSize = bufSize;
        this.channelHandlerList = channelHandlerList;
    }

    public void serverStart(){

        System.out.println("服务端正在启动");
        try {
            // 设置循环线程组事例
            bootstrap.group(bossGroup, workerGroup);

            // 设置channel工厂
            bootstrap.channel(NioServerSocketChannel.class);

            // 设置管道
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new MoRequestDecoder());
                    ch.pipeline().addLast(new MoResponseEncoder());
                    ch.pipeline().addLast(new MoServerHandler());
                   /* if(channelHandlerList != null){
                        for(ChannelHandler channelHandler : channelHandlerList){
                            ch.pipeline().addLast(channelHandler);
                        }
                    }*/
                }
            });

            // 链接缓冲池队列大小
            bootstrap.option(ChannelOption.SO_BACKLOG, bufSize);

            // 绑定端口
            bootstrap.bind(port).sync();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务端启动失败，失败原因-" + e.getMessage());
        }
        System.out.println("服务端启动成功");
    }

}
