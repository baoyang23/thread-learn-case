package com.yang.create;

import java.util.Map;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         :  计算线程在计算的时候休眠了4000毫秒
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ThreadJoinCase extends Thread {

    static int result = 0;

    public ThreadJoinCase(String name){ super(name);}

    public static void main(String[] args) {

        System.out.println("主线程执行");
        Thread t = new ThreadJoinCase("计算线程");
        t.start();
        System.out.println("result : " + result);

        try {
            long start = System.nanoTime();
            // t.join(2000)  效果不一样
            t.join();
            long end = System.nanoTime();
            System.out.println((end - start) / 1000000 + "毫秒后 : " + result);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        System.out.println(this.getName() + "开始计算....");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = (int) (Math.random()*10000);
        System.out.println(this.getName() + "结束计算....");
    }

}
