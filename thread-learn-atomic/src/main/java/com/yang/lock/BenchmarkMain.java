package com.yang.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 17:00
 * @Version 1.0
 * @qq: 1411091515
 */
public class BenchmarkMain {

    private Counter counter;
    private CyclicBarrier barrier;
    private int threadNum;
    private int loopNum;
    private String testName;

    public BenchmarkMain(Counter counter, int threadNum, int loopNum, String testName) {
        this.counter = counter;
        barrier = new CyclicBarrier(threadNum + 1);
        this.threadNum = threadNum;
        this.loopNum = loopNum;
        this.testName = testName;
    }

    public static void main(String[] args) throws Exception {
        int threadNum = 5000;
        int loopNum = 100;

        new BenchmarkMain(new SynchronizedBenchmarkCase(),threadNum,loopNum,"内部锁").test();
        new BenchmarkMain(new ReentrantLockUnfairBeanchmarCase(),threadNum,loopNum,"不公平重入锁").test();
        new BenchmarkMain(new ReentrantLockFairBeanchmarkCase(),threadNum,loopNum,"公平重入锁").test();

    }

    public void test() throws Exception {

        try{
            for(int i=0;i<threadNum;i++){
                new TestThread(counter,loopNum).start();
            }
            long start = System.currentTimeMillis();
            barrier.await();
            barrier.await();
            long end = System.currentTimeMillis();
            System.out.println(this.testName + " count value : " + counter.getValue());
            System.out.println(this.testName + " 花费时间 : " + (end - start) + "毫秒");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    class TestThread extends Thread {

        int loopNum = 100;
        private Counter counter;

        public TestThread(final Counter counter,int loopNum){
            this.counter = counter;
            this.loopNum = loopNum;
        }

        @Override
        public void run() {

            try{
                // 等待所有的线程开始
                barrier.await();
                for(int i=0;i < this.loopNum;i++){
                    counter.increment();
                }
                // 等待所有的线程完成
                barrier.await();
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
    }

}
