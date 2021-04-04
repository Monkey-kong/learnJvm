package com.monkeykong.c9_gc;

/**
 * @author alvin
 * @date 2020-07-22 22:12
 */
public class WhichIsNice {
    public static void main(String[] args) {

    }

    static void m1() {
        Object o = null;
        for (int i = 0; i < 100; i++) {
            o = new Object();
        }
    }

    static void m2() {
        for (int i = 0; i < 100; i++) {
            // 循环没结束，对象一直有引用指向，方法没结束，对象不会被回收
            Object o = new Object();
        }
    }
}
