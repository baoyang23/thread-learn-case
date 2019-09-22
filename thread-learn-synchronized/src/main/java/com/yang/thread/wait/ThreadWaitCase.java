package com.yang.thread.wait;

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
public class ThreadWaitCase {

    public static void main(String[] args) {

        ThreadWait tw = new ThreadWait("tw");
        try {
            synchronized (tw) {

                // 启动线程tw
                System.out.println(Thread.currentThread().getName() + " Start tw.");
                tw.start();

                System.out.println(Thread.currentThread().getName() + " wait()");
                tw.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ThreadWait extends Thread {

    public ThreadWait(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify() ");
            notify();
        }
    }
}
