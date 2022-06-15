package com.yacoding.jvm.c2_classloader;

public class T009_WayToRun {
    public static void main(String[] args) {
        for(int i=0; i<1000; i++)
            m();
        long start = System.currentTimeMillis();
        for(int i=0; i<1000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void m() {
        for(long i=0; i<1000; i++) {
            long j = i%3;
        }
    }
}