package com.monkeykong.c2_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author alvin
 * @date 2020-06-29 23:56
 * 自定义 classloader
 */
public class T007_AlvinClasssLoader extends ClassLoader {

    private int a;
    T007_AlvinClasssLoader(){
        super(null); // 指定 parent
        System.out.println("T006_AlvinClasssLoader default constructor....");
    }
    /**
     * 可以重写 loadClass 来打破双亲委派机制，实现自己的加载逻辑
     */
//    @Override
//    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
////         return super.loadClass(name, resolve);
//        // defineClass 是 final 方法，Object 类没法自己加载
//        synchronized (getClassLoadingLock(name)) {
//            // First, check if the class has already been loaded
//            Class<?> c = findLoadedClass(name);
//            if (c == null) {
//                c = findClass(name);
//            }
//            if (resolve) {
//                resolveClass(c);
//            }
//            return c;
//        }
//    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("D:\\01_code\\01_javasebasic\\",
                name.replaceAll("\\.", "/").concat(".class"));
//        File f = new File("D:\\01_code\\01_javasebasic\\learnJvm\\target\\classes\\",
//                name.replaceAll("\\.", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) >= 0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            // 把二进制内容转换为 class 对象返回
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception {
        T007_AlvinClasssLoader l = new T007_AlvinClasssLoader();
        Class<?> clazz = l.loadClass("Hello");
        // Class<?> clazz = l.loadClass("com.monkeykong.classloader.Hello");
        System.out.println("Hello的类加载器："+clazz.getClassLoader());
        clazz.getMethod("m").invoke(clazz.newInstance());
        // 可以手动改变自定义类加载器的 parent
        System.out.println(l.getParent());
    }
}
