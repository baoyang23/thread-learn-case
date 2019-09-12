package com.yang.safety;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/12 23:32
 * @Version 1.0
 * @qq: 1411091515
 */
public class SequenceNumber {

    /**
     *  Thread Number : Thread-0 ] s : [1]
     *  Thread Number : Thread-2 ] s : [1]
     *  Thread Number : Thread-1 ] s : [1]
     *  Thread Number : Thread-2 ] s : [2]
     *  Thread Number : Thread-0 ] s : [2]
     *  Thread Number : Thread-2 ] s : [3]
     *  Thread Number : Thread-1 ] s : [2]
     *  Thread Number : Thread-1 ] s : [3]
     *  Thread Number : Thread-0 ] s : [3]
     *  每个线程有独立的序列号;没有相互干扰
     *  ThreadLocal和线程同步机制都是为了
     * 解决多线程中相同变量的访问冲突问题
     */

    private static ThreadLocal<Integer> sqeNum = new ThreadLocal<Integer>(){

        @Override
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){
        sqeNum.set(sqeNum.get() + 1);
        return sqeNum.get();
    }

    static class ThreadClient extends Thread {

        private SequenceNumber sequenceNumber;

        public ThreadClient(SequenceNumber sequenceNumber){this.sequenceNumber = sequenceNumber;}

        @Override
        public void run() {
            for(int i=0;i < 3;i++){
                System.out.println(" Thread Number : " + Thread.currentThread().getName() + " ] s : [" + sequenceNumber.getNextNum() + "]");
            }
        }
    }

    public static void main(String[] args) {
        SequenceNumber sequenceNumber = new SequenceNumber();
        ThreadClient t1 = new ThreadClient(sequenceNumber);
        ThreadClient t2 = new ThreadClient(sequenceNumber);
        ThreadClient t3 = new ThreadClient(sequenceNumber);
        t1.start();
        t2.start();
        t3.start();

    }
}
