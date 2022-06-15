package com.yacoding.jvm.c2_classloader;

/**
 * @Author yaCoding
 * @create 2022-06-01 下午 3:40
 */

public class T002_ClassLoaderLevel {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());
//
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
//
       System.out.println(new T006_MSBClassLoader().getParent());//父加载器的加载器
        System.out.println(ClassLoader.getSystemClassLoader());
    }

}
