package com.yacoding.jvm.c4_RuntimeDataAreaAndInstructionSet;

import java.lang.instrument.Instrumentation;

/**
 * @Author yaCoding
 * @create 2022-06-15 下午 4:04
 */

public class ObjectSizeAgent {

    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }

}
