package com.yang.create.waits;

import java.util.concurrent.locks.LockSupport;

/****
 * author: BaoYang
 * data: 2023/3/25
 * desc:
 ***/
public class LockSupportUse {

    public static void main(String[] args) {

        ParkThread parkThread = new ParkThread();
        parkThread.start();
        LockSupport.unpark(parkThread);

    }

    static class ParkThread extends Thread {

        @Override
        public void run() {
            System.out.println("ParkThread 开始阻塞");
            LockSupport.park();
            System.out.println("ParkThread 结束阻塞");
        }
    }

}
