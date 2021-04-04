package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-07-16 22:01
 * 理解类加载过程
 */
public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        /**
         * new T() 在前面时输出 2
         * new T() 在后面时输出 3
         */
        System.out.println(T.count);
    }
}
class T {
    public static T t = new T(); // t：默认值 null
    public static int count = 2; // count：默认值 0

    // 普通成员变量也有两个过程，因为创建对象有申请空间和调用构造方法两个步骤。
    // 1. new T() 时，申请内存，m = 0
    // 2. 执行构造方法时，m = 8
    private int m = 8;

    private T() {
        count++;
    }
}
