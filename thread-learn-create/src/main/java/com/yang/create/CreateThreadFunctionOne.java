package com.yang.create;

/***********************************************************************
 *<PRE>
 *
 *  File Name       :  创建线程的方式一 ;  继承Thread 实现run方法
 *
 *  Creation Date   : 19-9-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class CreateThreadFunctionOne extends Thread {

    public CreateThreadFunctionOne(String name){ super(name); }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(this.getName() + " : " + i);
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            new CreateThreadFunctionOne("Thread Number : " + i).start();
        }

    }
}
