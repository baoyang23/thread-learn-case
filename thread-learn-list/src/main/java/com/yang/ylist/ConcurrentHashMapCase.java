package com.yang.ylist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class ConcurrentHashMapCase {

    /*private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();*/
    private static Map<String,String> map = new HashMap<>(16);

    public static void main(String[] args) {
        new MapThread("m1").start();
        new MapThread("m2").start();
    }

    private static void printAll() {

        String key, value;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            key = entry.getKey();
            value = entry.getValue();
            System.out.print("key : " + key + " value : " + value);
        }
        System.out.println();
    }

    private static class MapThread extends Thread {

        public MapThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                String threadName = Thread.currentThread().getName() + "-" + i;
                map.put(i + "", threadName);
                printAll();
            }
        }
    }

}
