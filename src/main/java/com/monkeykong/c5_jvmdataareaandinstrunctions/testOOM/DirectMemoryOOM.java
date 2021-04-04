package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 直接通过反射获取 Unsafe 实例，然后通过 allocateMemory 来申请内存
 * 问题：加了 -XX:+HeapDumpOnOutOfMemoryError 也不导出堆文件？
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        int i = 0;
        try {
            while (true) {
                i++;
                unsafe.allocateMemory(_1MB);
            }
        } catch (Error e) {
            System.out.println("i:" + i);
            throw e;
        }
    }
}
