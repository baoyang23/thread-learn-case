package com.yang.create;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 创建线程方法二
 *
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         :  实现 Runnable接口,重写run方法
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class CreateThreadFunctionTwo implements Runnable {


    @Override
    public void run() {

        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName() + " Number : " + i);
        }

    }

    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            CreateThreadFunctionTwo createThreadFunctionTwo = new CreateThreadFunctionTwo();
            new Thread(createThreadFunctionTwo,"thread : " + i).start();
        }

    }

}
