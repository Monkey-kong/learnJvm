package com.monkeykong.c2_classloader;

/**
 * @author alvin
 * @date 2020-07-16 20:28
 */
public class T010_Parent {
    private static T006_AlvinClasssLoader parent = new T006_AlvinClasssLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            // 自定义 parent
            super(parent);
        }
    }
}
