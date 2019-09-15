package com.yang.yatomic;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 0:34
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicCounterMain extends Thread {

    /**
     * generatord number : 1
     * generatord number : 4
     * generatord number : 3
     * generatord number : 2
     * generatord number : 7
     * generatord number : 8
     * generatord number : 6
     * generatord number : 5
     * generatord number : 9
     * generatord number : 10
     *会发现 10 个线程运行中，没有重复的数字，原子量类使用本机 CAS 实现了值修改的原
     * 子性
     */

    AtomicCounter atomicCounter;

    public AtomicCounterMain(AtomicCounter atomicCounter) {
        this.atomicCounter = atomicCounter;
    }

    @Override
    public void run() {
       int i = atomicCounter.increment();
        System.out.println("generatord number : " + i);
    }

    public static void main(String[] args) {
        AtomicCounter atomicCounterMain = new AtomicCounter();
        for(int i=0;i<10;i++){
            new AtomicCounterMain(atomicCounterMain).start();
        }
    }
}
