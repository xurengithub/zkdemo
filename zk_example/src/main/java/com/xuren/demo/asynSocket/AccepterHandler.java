package com.xuren.demo.asynSocket;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author xuren
 * @date 2021/12/24
 */
public class AccepterHandler implements CompletionHandler<AsynchronousSocketChannel, Nio2Server> {

    @Override
    public void completed(AsynchronousSocketChannel result, Nio2Server attachment) {
        attachment.serverSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadHandler(result));
    }

    @Override
    public void failed(Throwable exc, Nio2Server attachment) {

    }
}
