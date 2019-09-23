package com.yang.ylist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-22
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class CopyOnWriteArraySetCase {

    /*private static CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet();*/

    private static Set<String> set = new HashSet<>(20);

    public static void main(String[] args) {

        new SetList("s1").start();
        new SetList("s2").start();

    }

    private static void printAll() {
        String value = null;
        Iterator<String> iterable = set.iterator();
        while (iterable.hasNext()) {
            value = iterable.next();
            System.out.print(value + ",");
        }
        System.out.println();
    }

    private static class SetList extends Thread {

        public SetList(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (++i < 10) {
                String threadName = Thread.currentThread().getName() + " - " + (i % 6);
                set.add(threadName);
                printAll();
            }
        }
    }

}
