package com.yacoding.jvm.c2_classloader;

/**
 * @Author yaCoding
 * @create 2022-06-03 下午 10:03
 */

public class T010_Parent {

    private static T006_MSBClassLoader parent = new T006_MSBClassLoader();
    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
        }
    }
}
