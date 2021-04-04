package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

/**
 * String::intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的
 * 字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加
 * 到常量池中，并且返回此String对象的引用
 * jdk6: false false。因为intern会把首次遇到的字符串复制到永久代的字符串常量池，而StringBuilder对象位于堆中
 * jdk7: true false。第二个false是因为java这个字符串在执行StringBuilder之前已经出现过，不符合intern()首次遇到原则
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
