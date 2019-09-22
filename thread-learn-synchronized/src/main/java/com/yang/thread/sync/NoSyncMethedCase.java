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

class Count{

    /**
     *  使用同步
     */
    public void synMethod(){
        synchronized (this) {
            try {
                for(int i = 0;i < 5;i++){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 没有使用同步
     */
    public /*synchronized*/ void noSyncMethod(){
        try {
            for(int i = 0;i < 5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " syncMethod loop " + i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

public class NoSyncMethedCase {

    /**
     *
     * 同一个类中　; synchronized 不会阻塞没有　synchronized　的
     *  打开注释和使用上注释就可以看到显著的效果
     * @param args
     */

    public static void main(String[] args) {

        final Count count = new Count();
        Thread t1 = new Thread( () -> {
            count.synMethod();
        },"t1");

        Thread t2 = new Thread( () -> {
            count.noSyncMethod();
        },"t2");

        t1.start();
        t2.start();
    }


}
