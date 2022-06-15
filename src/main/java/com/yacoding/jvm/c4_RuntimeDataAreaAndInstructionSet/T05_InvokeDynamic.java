package com.yacoding.jvm.c4_RuntimeDataAreaAndInstructionSet;

public class T05_InvokeDynamic {

    public static void main(String[] args) {
        //lambda
        I i = C::n;//i会指向对应的对象
        I i2 = C::n;
        I i3 = C::n;
        I i4 = () -> {
            C.n();
        };
        //产生类的内部类的内部类
        System.out.println(i.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());
//        for(;;) {I j = C::n;} //MethodArea <1.8 Perm Space (FGC不回收)
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}