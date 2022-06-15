package com.yacoding.jvm.c5_gc;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 8:57
 */

public class T01_HelloGC {

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[1024 * 1024];
        }
    }
}
