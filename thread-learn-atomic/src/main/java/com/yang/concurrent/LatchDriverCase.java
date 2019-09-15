package com.yang.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 16:03
 * @Version 1.0
 * @qq: 1411091515
 */
public class LatchDriverCase {

    private static final int N = 5;

    public static void main(String[] args) throws Exception {

        CountDownLatch startSignal = new CountDownLatch(1);

        CountDownLatch doneSignal = new CountDownLatch(N);

        for(int i=0;i<N;++i){
            new Thread(new LatchWorker(startSignal,doneSignal), " t ==> " + i).start();
        }

        long startTime = System.nanoTime();
        startSignal.countDown();
        doneSignal.await();
        long endTime = System.nanoTime();

        System.out.println("all worker take time (ms) : " + (endTime - startTime) / 1000000);
    }

    static  class LatchWorker implements Runnable {

        private final CountDownLatch startSignal;

        private final CountDownLatch doneSignal;

        public LatchWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try{
                startSignal.await();
                doWork();
                doneSignal.countDown();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public void doWork(){
            System.out.println(Thread.currentThread().getName() + " is working....");
            int sum = 0;
            sum += (0 + 10000000) * 10000000 / 2;
        }
    }

}
