package com.yang.thread.objs;

import org.openjdk.jol.info.ClassLayout;

public class ObjectMain {

    /**
     * -XX:-UseCompressedOops
     * @param args
     */
    public static void main(String[] args) {

        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

    }

}
