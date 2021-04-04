package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args:
 *  JDK7：-XX:PermSize=10M -XX:MaxPermSize=10M
 *  JDK8：-XX:MaxMetaSpaceSize=10M
 *  Caused by: java.lang.OutOfMemoryError: Metaspace
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        // 使用cglib操作字节码，生成大量动态类代理类
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject {}
}
