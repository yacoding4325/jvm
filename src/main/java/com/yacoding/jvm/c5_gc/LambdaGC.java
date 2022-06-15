package com.yacoding.jvm.c5_gc;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 8:56
 */

public class LambdaGC {
    public static void main(String[] args) {
        for(;;) {
            I i = C::n;
        }
    }

    public static interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }

}