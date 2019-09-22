package com.yang.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 15:01
 * @Version 1.0
 * @qq: 1411091515
 */
public class CopyOnWriteCase {

    /**
     * CopyOnWriteArrayList 和 ArrayList 这两个实例
     * 在得到每一个实
     * 例 的 当 ArrayList 迭 代 因 一 个
     * Conc ntModificationException 问题而立即停止时， CopyOnWriteArrayList 迭代可以继续，
     * 不会抛出异常，因为原来的集合是在得到 iterator 之后改变的
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        String [] strs = {"aa","bb","cc"};

        List l1 = new CopyOnWriteArrayList(Arrays.asList(strs));
        List l2 = new ArrayList(Arrays.asList(strs));

        Iterator i1 = l1.iterator();
        Iterator i2 = l2.iterator();

        l1.add("new");
        l2.add("new");
        try{
            printAll(i2);
        }catch (Exception e){
            System.out.println("Not get here");
            e.printStackTrace();
        }

        try{
            printAll(i2);
        }catch (Exception e){
            System.out.println("Will get\n" +
                    "here.ConcurrentModificationException occurs!");
            e.printStackTrace();
        }

    }

    private static void printAll(Iterator iterable){
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }
    }

}
