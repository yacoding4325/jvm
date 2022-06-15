package com.yacoding.jvm.c5_gc;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 9:09
 */

//-XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB -Xlog:c5_gc*
// 逃逸分析 标量替换 线程专有对象分配
public class TestTLAB {
    class User {
        String name;
        int id;

        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    void alloc(int i) {
        new User( "name " ,i + i);
    }

    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for(int i=0; i<1000_0000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}