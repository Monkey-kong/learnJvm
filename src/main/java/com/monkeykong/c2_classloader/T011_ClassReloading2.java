package com.monkeykong.c2_classloader;

import java.io.*;

/**
 * @author alvin
 * @date 2020-07-16 20:59
 * 重写 loadclass 方法，打破双亲委派机制，实现热加载
 * 问题：既然可以随便重写，那不是随便谁都可以打破？
 */
public class T011_ClassReloading2 {

    private static class MyLoader extends ClassLoader {
        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
           // File f = new File("D:/01_code/01_javasebasic/learnJvm/target/classes/" + name.replaceAll("\\.", "/").concat(".class"));
            File f = new File("D:\\01_code\\01_javasebasic\\learnJvm\\target\\classes\\",
                    name.replaceAll("\\.", "/").concat(".class"));
            if (!f.exists()) {
                return super.loadClass(name, false);
            }
            try {
                InputStream is = new FileInputStream(f);
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.loadClass(name, false);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader m = new MyLoader();
        Class clazz = m.loadClass("com.monkeykong.c2_classloader.Hello");

        m = new MyLoader();
        Class clazzNew = m.loadClass("com.monkeykong.c2_classloader.Hello");

        System.out.println(clazz == clazzNew);
    }
}
