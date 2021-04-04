package com.monkeykong.c9_gc;

/**
 * @author alvin
 * @date 2020-07-22 21:52
 */
public class LambdaGC {
    public static void main(String[] args) {
        for (;;) {
            // 会不断产生内部类,并且产生内部类对象
            // 每个 lambda 对象会产生一个 class
            I i = C::n;
            // i.m();
        }
    }

    public static interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}
