package com.yang.atom;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 23:27
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicCounterMain extends Thread {

    AtomicCounter counter;

    public AtomicCounterMain( AtomicCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        int i = counter.increment();
        System.out.println("generated number : " + i);
    }

    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();
        for(int i=0;i<10;i++){
            new AtomicCounterMain(atomicCounter).start();
        }

    }
}
