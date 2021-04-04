package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-06-29 23:11
 * 手动加载一个类
 * 什么时候需要手动加载一个类?
 * - spring 动态代理生成的代理类
 * - tomcat
 * - jrebel 热部署
 */
public class T005_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        // 拿到 classloader
        ClassLoader appClassLoader = T005_LoadClassByHand.class.getClassLoader();
        // 加载
        Class clazz = appClassLoader.loadClass("com.monkeykong.c2_classloader.T005_LoadClassByHand");
        System.out.println(clazz.getName());
    }
}
