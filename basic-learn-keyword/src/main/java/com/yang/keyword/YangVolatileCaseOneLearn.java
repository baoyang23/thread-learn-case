package com.yang.keyword;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-10-10
 *
 *  Author          : Gavin
 *
 *  Purpose         : volatile 关键字的学习
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class YangVolatileCaseOneLearn {

    private static volatile boolean isStop = false;

    public static void stopit() {
        isStop = true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new ThreadOne().start();
        while (!isStop){

        }

        System.out.println("Stop ");
        System.out.println(" 消耗时间 :  " + (System.currentTimeMillis() - startTime));
    }

    static class ThreadOne extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            stopit();
        }
    }

}
