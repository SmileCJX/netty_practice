package pers.caijx.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 接收/处理/响应客户端websocket请求的核心业务处理类
 * Created by caijx on 2018/9/6/006.
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object>{


    /**
     * 服务端请求客户端websocket请求的核心方法
     * @param channelHandlerContext
     * @param
     * @throws Exception
     */
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    /**
     * 客户端与服务端创建连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.add(ctx.channel());
        System.out.println("客户端与服务端连接开启...");
    }

    /**
     * 客户端与服务端断开连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.remove(ctx.channel());
        System.out.println("客户端与服务端连接关闭...");
    }

    /**
     * 服务端接收客户端发送过来的数据结束之后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 工程出现异常的情况调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
