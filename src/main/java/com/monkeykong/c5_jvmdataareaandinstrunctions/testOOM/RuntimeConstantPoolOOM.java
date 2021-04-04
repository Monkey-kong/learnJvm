package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * JDK6 或更早之前 PermSize 和 MaxPermSize 可以限制永久代大小。
 * 即可间接限制其中常量池的容量。
 * JDK6 环境运行：java.lang.OutOfMemoryError: PermGen space
 * 这也说明常量池位于 PermGen
 * JDK7 开始，常量池被移至Java堆中，所以限制PermSize或者jdk8限制 -XX:MaxMetaspaceSize 对于这个例子来说都是无意义的。
 * 所以 JDK7 开始，加上 -Xmx6M 后，就会出现常量池 OOM 了
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用 Set 保持着常量池引用，避免 Full GC 回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在 short 范围内足以让 6MB 的 PermSize 产生 OOM 了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
