//package com.monkeykong.jmm;
//
//import com.monkeykong.jvm.agent.ObjectSizeAgent;
//
///**
// * @author alvin
// * @date 2020-07-18 21:39
// * 运行时需要 Agent Jar 的类,加入参数:
// *   -javaagent:D:\01_code\01_javasebasic\ObjectSize\out\artifacts\ObjectSize_jar\ObjectSize.jar
// * 关闭压缩 class pointer 压缩：-XX:-UseCompressedClassPointers
// */
//public class T03_SizeOfAnObject {
//    public static void main(String[] args) {
//        // 16:8(头 mark word)+4(class pointer 压缩)+4(padding)
//        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
//        // 32:8(头 mark word)+4(class pointer 压缩)+4(数组长度)+9(数组数据)+7(padding)
//        System.out.println(ObjectSizeAgent.sizeOf(new byte[] {1,2,3,4,1,1,1,1,1}));
//        // 32
//        System.out.println(ObjectSizeAgent.sizeOf(new P()));
//    }
//
//    // 一个 Object 占多少个字节
//    //  -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
//    // Oops = ordinary object pointers 是否压缩普通对象指针
//    private static class P {
//                        // 8 _markword
//                        // 4 _class pointer
//        int id;         // 4
//        String name="123456789";    // 4 因为是 64 位机器，默认为 8，但是 UseCompressedOops 开启了，所以为 4
//        int age;        // 4
//
//        byte b1;        // 1
//        byte b2;        // 1
//
//        Object o;       // 4
//        byte b3;        // 1
//    }
//}
