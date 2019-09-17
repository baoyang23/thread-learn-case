package com.yang.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M --XX:MaxDirectMemorySize=10M
 *
 * @Author: Mu_Yi
 * @Date: 2019/9/17 20:34
 * @Version 1.0
 * @qq: 1411091515
 */
public class SimulationDirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field[] declaredFields = Unsafe.class.getDeclaredFields();
        Field unsafeField = declaredFields[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory( _1MB);
        }
    }

}
