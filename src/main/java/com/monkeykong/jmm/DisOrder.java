package com.monkeykong.jmm;

/**
 * @author alvin
 * @date 2020-07-17 21:27
 */
public class DisOrder {
    private static int a, b;
    private static int x, y;
    /**
     * 假设不会乱序执行
     * a=1 x=b b=1 y=a ==>x=0,y=1
     * a=1 b=1 x=b y=a ==>x=1,y=1
     * a=1 b=1 y=a x=b ==>x=1,y=1
     *
     * b=1 y=a a=1 x=b ==>x=1,y=0
     * b=1 a=1 x=b y=a ==>x=1,y=1
     * b=1 a=1 y=a x=b ==>x=1,y=1
     *
     * 乱序
     * x=b y=a a=1 b=1
     * y=a x=b a=1 b=1
     */
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(() -> {
                // shortWait(100000);
                a = 1;
                x = b;
            });
            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();other.start();
            one.join();other.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            System.out.println(result);
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            }
        }
    }

    private static void shortWait(int interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
