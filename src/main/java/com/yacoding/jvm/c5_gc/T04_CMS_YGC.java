package com.yacoding.jvm.c5_gc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 9:02
 */

public class T04_CMS_YGC {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Object o = new Object();
            o = null;
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}