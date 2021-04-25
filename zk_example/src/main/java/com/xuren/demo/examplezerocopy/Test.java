package com.xuren.demo.examplezerocopy;

import org.jboss.netty.channel.DefaultFileRegion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("xxx");
        FileChannel channel = inputStream.getChannel();
        channel.transferTo(0,0,null);
        channel.transferFrom(null,0,0);

        DefaultFileRegion defaultFileRegion = new DefaultFileRegion(inputStream.getChannel(), 0, 1);
    }
}
