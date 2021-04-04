package com.monkeykong.c6_gc;

/**
 * @author alvin
 * @date 2020-07-19 21:55
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
 * 不进行逃逸分析 不进行标量替换 不进行线程专有对象分配
 * 加上上面参数后，效率明显变低。
 */
public class TestTLAB {
    // User u;
    class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    void alloc(int i) {
        new User(i, "name" + i);
    }

    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i=0; i<1000_0000; i++) t.alloc(i);
        System.out.println(System.currentTimeMillis() - start);
    }
}
