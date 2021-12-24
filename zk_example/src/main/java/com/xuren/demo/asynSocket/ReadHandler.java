package com.xuren.demo.asynSocket;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author xuren
 * @date 2021/12/24
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }
    @Override
    public void completed(Integer result, ByteBuffer attachment) {

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
