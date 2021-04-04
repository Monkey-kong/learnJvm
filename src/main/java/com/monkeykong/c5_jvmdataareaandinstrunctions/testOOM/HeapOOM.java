package com.monkeykong.c5_jvmdataareaandinstrunctions.testOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将 Xms 和 Xmx 设置为一样可以避免堆自动扩展
 * HeapDumpOnOutOfMemoryError可以让虚拟机出现OOM时Dump出当前的内存堆转储快照，以便事后分析
 */
public class HeapOOM {
    // 静态内部类？
    static class OOMobject {

    }

    public static void main(String[] args) {
        List<OOMobject> list = new ArrayList<OOMobject>();
        while (true) {
            list.add(new OOMobject());
        }
    }
}
