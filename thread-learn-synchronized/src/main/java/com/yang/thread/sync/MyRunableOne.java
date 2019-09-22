package com.yang.thread.sync;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-21
 *
 *  Author          : Gavin
 *
 *  Purpose         :  当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其
 *                      他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *
 *  History         : 
 *        当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 *        其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *
 *        当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
 *
 *        当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时,
 *        其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *</PRE>
 ***************************************************************************/
public class MyRunableOne implements Runnable {

    @Override
    public void run() {
        // 当前类的对象,即synchronized(this) 当前所在类的对象
        synchronized (this) {
            try{
                for(int i=0;i<5;i++){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        MyRunableOne one = new MyRunableOne();
        // MyRunableOne two = new MyRunableOne();

        Thread t1 = new Thread(one,"t1");
        Thread t2 = new Thread(one,"t2");

        t1.start();
        t2.start();
    }
}
