package com.yacoding.jvm.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 2:28
 */

public class Hello_02 {

    public static void main(String[] args) {
        Hello_02 h = new Hello_02();
        h.m1();
//        System.out.println();
    }

    public void m1() {
        int i = 200;
    }

    public void m2(int k) {
        int i = 300;
    }

    public void add(int a, int b) {
        int c = a + b;
    }

    public void m3() {
        Object o = null;
    }

    public void m4() {
        Object o = new Object();
    }

}