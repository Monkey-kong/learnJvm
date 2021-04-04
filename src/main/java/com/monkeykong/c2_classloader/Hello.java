package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-06-30 0:04
 */
public class Hello {
    public static void main(String[] args) {
        new Hello().m();
    }
    public void m() {
        System.out.println("m .....");
    }
}
