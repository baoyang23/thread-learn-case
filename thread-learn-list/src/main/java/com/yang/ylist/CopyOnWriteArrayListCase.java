package com.yang.ylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
public class CopyOnWriteArrayListCase {


    /*private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();*/
    private static List<String> list = new ArrayList<>(20);

    public static void main(String[] args) {

        new ListThread("ta").start();
        new ListThread("tb").start();

    }

    private static void printAll() {
        String value = null;
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            value = iter.next();
            System.out.print(value + ",");
        }
        System.out.println();
    }

    private static class ListThread extends Thread {

        public ListThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (++i < 6) {
                String threadName = Thread.currentThread().getName() + " - " + i;
                list.add(threadName);
                printAll();
            }
        }
    }

}
