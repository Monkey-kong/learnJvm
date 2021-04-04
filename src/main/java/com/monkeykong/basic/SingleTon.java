package com.monkeykong.basic;

/**
 * @author alvin
 * @date 2020-11-22 22:57
 */
public class SingleTon {
    // 屏蔽掉构造函数不让别人创建对象
    private SingleTon() {}

    // 定义唯一实例
    private volatile static SingleTon singleTon;

    // 暴露获取实例的方法
    // 思考：为啥不直接再 getSingleTon 方法上上锁。
    public static SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                // 思考：为啥还要检查一遍
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
