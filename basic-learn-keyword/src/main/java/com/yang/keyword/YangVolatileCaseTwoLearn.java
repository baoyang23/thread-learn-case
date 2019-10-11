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
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class YangVolatileCaseTwoLearn {

    private static  int i = 0;

    public static synchronized void add(){
        i++;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        new ThreadOne().start();
        while (i < 100){}

        System.out.println(" 线程 Stop ");
        System.out.println(" 消耗的时间 : " + (System.currentTimeMillis() - startTime));
    }

    static class ThreadOne extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }

            for(int n=0;n < 200;n++){
                add();
            }
        }
    }
}
