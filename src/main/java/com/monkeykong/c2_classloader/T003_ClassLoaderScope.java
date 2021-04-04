package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-06-29 22:56
 */
public class T003_ClassLoaderScope {
    public static void main(String[] args) {
        // bootstrap classloader 加载哪些类?
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));

        // ext classloader 加载哪些类?
        System.out.println("------ext------");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        // app classloader 加载哪些类?
        System.out.println("-----app-------");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
    }
}
