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
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class MyThreadOne extends Thread {

    public MyThreadOne(String name){ super(name); }

    @Override
    public void run() {
        // t1 和　t2 是二个不同的对象 this 是当前类对象的锁
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
        MyThreadOne t1 = new MyThreadOne("t1");
        MyThreadOne t2 = new MyThreadOne("t2");
        t1.start();
        t2.start();
    }
}
