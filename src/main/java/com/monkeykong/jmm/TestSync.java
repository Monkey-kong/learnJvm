package com.monkeykong.jmm;

/**
 * @author alvin
 * @date 2020-07-18 20:21
 */
public class TestSync {
    synchronized void m() {

    }

    void n() {
        synchronized (this) {

        }
    }

    public static void main(String[] args) {

    }
}
