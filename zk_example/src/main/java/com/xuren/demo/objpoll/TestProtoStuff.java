package com.xuren.demo.objpoll;

import io.protostuff.ByteArrayInput;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.IOException;

/**
 * @author xuren
 * @date 2021/11/19
 */
public class TestProtoStuff {
    public static void main(String[] args) throws IOException {
        Foo foo = new Foo("foo", 1);

        // this is lazily created and cached by RuntimeSchema
        // so its safe to call RuntimeSchema.getSchema(Foo.class) over and over
        // The getSchema method is also thread-safe
        Schema<Foo> schema = RuntimeSchema.getSchema(Foo.class);

        // Re-use (manage) this buffer to avoid allocating on every serialization
        LinkedBuffer buffer = LinkedBuffer.allocate(512);

        // ser
        final byte[] protostuff;
        try
        {
            System.out.println(foo);
            protostuff = ProtostuffIOUtil.toByteArray(foo, schema, buffer);
        }
        finally
        {
            buffer.clear();
        }
        // deser
//        Foo fooParsed = schema.newMessage();
//        ProtostuffIOUtil.mergeFrom(protostuff, fooParsed, schema);

//        for (int i = 0; i < 10; i ++) {
//            new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    Foo fooParsed2 = schema.newMessage();
//                    ProtostuffIOUtil.mergeFrom(protostuff, fooParsed2, schema);
//                    System.out.println(Thread.currentThread().getName() + ":" + fooParsed2);
//                }
//            }).start();
//        }

        ByteArrayInput input = new ByteArrayInput(protostuff, 0, protostuff.length, true);
        Foo foo1 = new Foo("1hahaha",0);
        schema.mergeFrom(input, foo1);
        System.out.println(foo1);
    }
}
