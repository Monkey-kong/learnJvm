//package com.monkeykong.c11_fiber;
//
//import co.paralleluniverse.fibers.Fiber;
//import co.paralleluniverse.strands.SuspendableRunnable;
//
///**
// * @author alvin
// * @date 2020-09-17 22:24
// * 纤程版 3201
// */
//public class HelloFiber2 {
//    public static void main(String[] args) throws  Exception {
//        long start = System.currentTimeMillis();
//        int size = 10000;
//        Fiber<Void>[] fibers = new Fiber[size];
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i] = new Fiber<Void>((SuspendableRunnable) () -> calc());
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].start();
//        }
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i].join();
//        }
//        long end = System.currentTimeMillis();
//        // 3201
//        System.out.println(end - start);
//    }
//    // 模拟耗时操作
//    static void calc() {
//        int result = 0;
//        for (int m = 0; m < 10000; m++) {
//            for (int i = 0; i < 200; i++) result += i;
//        }
//    }
//}
