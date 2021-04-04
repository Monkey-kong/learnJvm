package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

/**
 * VM Args: -Xss2M (这时候不妨设置大一些)
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
