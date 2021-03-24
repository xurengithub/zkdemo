package com.xuren.demo.exampleunsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class People {
    private volatile int id;
    private static long valueOffset;
    private static Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");

            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            valueOffset = unsafe.objectFieldOffset(People.class.getDeclaredField("id"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        unsafe.getAndSetInt(this, valueOffset, id);
    }

}
