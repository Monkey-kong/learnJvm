package com.monkeykong.c9_gc;

/**
 * @author alvin
 * @date 2020-07-22 22:09
 */
public class StackOverFlow {
    public static void main(String[] args) {
        m();
    }

    static void m() {
        m();
    }
}
