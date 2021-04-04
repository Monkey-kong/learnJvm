package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-06-29 21:57
 * 类加载器级别：bootstrap -> extension -> app -> custom
 */
public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println("String的类加载器："+String.class.getClassLoader());
        // extension，c++ 实现，打印 sun.misc.Launcher$ExtClassLoader@6d6f6e28
        // System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println("T002_ClassLoaderLevel的类加载器："+T002_ClassLoaderLevel.class.getClassLoader());
        System.out.println("AppClassLoader的类加载器："+T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
        System.out.println("自定义类加载器的parent："+new T006_AlvinClasssLoader().getParent());
        System.out.println("系统类加载器："+ClassLoader.getSystemClassLoader());
    }
}
