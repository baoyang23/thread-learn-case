package com.yang.dead;

import sun.misc.Unsafe;

/**
 *  死锁的模拟
 * @Author: Mu_Yi
 * @Date: 2019/9/15 23:01
 * @Version 1.0
 * @qq: 1411091515
 */
public class DeadLock {

    public void harness()throws Exception {
        StringBuffer sOne = new StringBuffer("sOne");
        StringBuffer sTwo = new StringBuffer("sTwo");

        Thread tOne = new DThread(sOne,sTwo);
        Thread tTwo = new DThread(sTwo,sOne);
        tOne.start();
        tTwo.start();
        tOne.join();
        tTwo.join();

    }

    public static void main(String[] args) throws Exception {
        DeadLock d = new DeadLock();
        d.harness();
    }

    class DThread extends Thread {

        StringBuffer sOne;

        StringBuffer sTwo;

        public DThread(StringBuffer sOne,StringBuffer sTwo){
            this.sOne = sOne;
            this.sTwo = sTwo;
        }

        @Override
        public void run() {
            synchronized (sOne){
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                synchronized (sTwo){

                }
            }
        }
    }
}
