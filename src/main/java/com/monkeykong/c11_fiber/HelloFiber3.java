//package com.monkeykong.c11_fiber;
//
//import co.paralleluniverse.fibers.Fiber;
//import co.paralleluniverse.strands.SuspendableRunnable;
//
///**
// * @author alvin
// * @date 2020-09-17 22:24
// * 纤程版 467
// */
//public class HelloFiber3 {
//    public static void main(String[] args) throws  Exception {
//        long start = System.currentTimeMillis();
//        int size = 10000;
//        int threadSize = 10;
//        int batchSize = size/threadSize;
//
//        Fiber<Void>[] fibers = new Fiber[size];
//        for (int i = 0; i < fibers.length; i++) {
//            fibers[i] = new Fiber<Void>((SuspendableRunnable) () -> calc());
//        }
//
//        Thread[] threads = new Thread[threadSize];
//        for (int j = 0; j < threads.length; j++) {
//            threads[j] = new Thread(() -> {
//                try {
//                    for (int i = 0; i < batchSize; i++) {
//                        fibers[i].start();
//                    }
//                    for (int i = 0; i < batchSize; i++) {
//                        fibers[i].join();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
//        long end = System.currentTimeMillis();
//        // 467
//        System.out.println(end - start);
//    }
//    static void calc() {
//        int result = 0;
//        for (int m = 0; m < 10000; m++) {
//            for (int i = 0; i < 200; i++) result += i;
//        }
//    }
//}
