package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-07-16 20:49
 * 重新定义新的 classloader 还是得到一样的 class，说明没有打破双亲委派机制
 */
public class T011_ClassReloading1 {
    public static void main(String[] args) throws ClassNotFoundException {
        T006_AlvinClasssLoader alvinClasssLoader = new T006_AlvinClasssLoader();
        Class<?> clazz = alvinClasssLoader.loadClass("com.monkeykong.c2_classloader.Hello");

        alvinClasssLoader = null;
        System.out.println(clazz.hashCode());

        alvinClasssLoader = null;

        alvinClasssLoader = new T006_AlvinClasssLoader();
        Class<?> clazz1 = alvinClasssLoader.loadClass("com.monkeykong.c2_classloader.Hello");
        System.out.println(clazz1.hashCode());
        // true
        System.out.println(clazz == clazz1);
    }
}
