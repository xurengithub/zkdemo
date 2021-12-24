package com.xuren.demo.asynSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuren
 * @date 2021/12/24
 */
public class Nio2Server {
    public AsynchronousServerSocketChannel serverSocketChannel;
    void listen() throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(service, 1);
        serverSocketChannel = AsynchronousServerSocketChannel.open(group);
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.accept(this, new AccepterHandler());
    }

    public static void main(String[] args) throws IOException {
        Nio2Server nio2Server = new Nio2Server();
        nio2Server.listen();
    }
}
