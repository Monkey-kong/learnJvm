package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

/**
 * VM Args: -Xss128k
 * -Xss 可以指定栈容量
 * 随着 Xss 增大，stackLength 增大。
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
