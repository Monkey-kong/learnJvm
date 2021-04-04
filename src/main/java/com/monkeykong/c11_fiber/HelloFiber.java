package com.monkeykong.c11_fiber;

/**
 * @author alvin
 * @date 2020-07-25 0:28
 * 线程版本 8462
 */
public class HelloFiber {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int size = 10000;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> calc());
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        long end = System.currentTimeMillis();
        // 8462
        System.out.println(end - start);
    }
    // 模拟耗时操作
    static void calc() {
        int result = 0;
        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < 200; i++) result += i;
        }
    }
}
