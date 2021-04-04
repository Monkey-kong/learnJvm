package com.monkeykong.c7_gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alvin
 * @date 2020-07-20 21:12
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("Hello GC");
        List list = new LinkedList();
        for(;;) {
            // 1M
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
