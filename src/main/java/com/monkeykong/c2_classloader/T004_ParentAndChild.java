package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-06-29 22:50
 */
public class T004_ParentAndChild {
    public static void main(String[] args) {
        // AppClassloader
        System.out.println(T004_ParentAndChild.class.getClassLoader());
        // AppClassloader is loaded by bootstrap classloader,print null
        System.out.println(T004_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        // the parent classloader of AppClassloader  => ExtClassLoader
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent());
        // the parent classloader of ExtClassLoader => bootstrap classloader,print null
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent());
//        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent().getParent());
    }
}
