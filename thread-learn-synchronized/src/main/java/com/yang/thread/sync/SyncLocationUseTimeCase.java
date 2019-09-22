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
public class SyncLocationUseTimeCase {

    public synchronized void syncMthod(){
        for(int i=0;i<1000000;i++){
        };
    }

    public void syncBlock(){
        synchronized (this){
            for(int i=0;i<1000000;i++){

            };
        }
    }

    public static void main(String[] args) {
        SyncLocationUseTimeCase obj = new SyncLocationUseTimeCase();
        long startTime = System.currentTimeMillis();
        obj.syncMthod();
        System.out.println(" 方法上加锁消耗时间 : " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        obj.syncBlock();
        System.out.println(" 代码块加锁用时间 : " + (System.currentTimeMillis() - startTime));
    }
}
