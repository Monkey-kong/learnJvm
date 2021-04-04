package com.monkeykong.c5_jvmdataareaandinstrunctions;

/**
 * @author alvin
 * @date 2020-07-19 20:05
 */
public class T04_InvokeDynamic {
    public static void main(String[] args) {
        I i = C::n;
        I i2 = C::n;
        I i3 = C::n;
        System.out.println(i.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());
        // 可能内存溢出
//        for (;;) {I j = C::n} // MethodArea < 1.8 Perm Space(FGC 不回收)
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}
