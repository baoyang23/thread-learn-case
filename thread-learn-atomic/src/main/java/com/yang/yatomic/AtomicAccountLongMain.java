package com.yang.yatomic;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 0:54
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicAccountLongMain extends Thread {

    AtomicAccount atomicAccount;

    int delay;

    public AtomicAccountLongMain(AtomicAccount atomicAccount, int delay) {
        this.atomicAccount = atomicAccount;
        this.delay = delay;
    }

    @Override
    public void run() {
        atomicAccount.deposit(100L,delay);
    }

    public static void main(String[] args) {
        AtomicAccount account = new AtomicAccount(100L);
        AtomicAccountLongMain t1 = new AtomicAccountLongMain(account,1000);
        AtomicAccountLongMain t2 = new AtomicAccountLongMain(account,0);
        t1.start();
        t2.start();
    }
}
