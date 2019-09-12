package com.yang.create;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         :  Sleep()的使用  注意有InterruptedException 抛出
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ThreadSleepCase {

    public static void main(String[] args) {

        String [] arg = {"one","two","three","for"};
        long start = System.currentTimeMillis();
        for(int i=0;i<arg.length;i++){
            try{
                System.out.println(arg[i]);
                // 线程休眠
                Thread.sleep(1000);
            }catch (Exception e){e.printStackTrace();}
        }

        long end = System.currentTimeMillis();
        System.out.println("总共的消耗时间 : " + (end -start));
    }

}
