package com.yang.yatomic;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 0:43
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicAccountMain extends Thread {

    AtomicAccount atomicAccount;

    int delay;

    public AtomicAccountMain(AtomicAccount atomicAccount,int delay){
        this.atomicAccount = atomicAccount;
        this.delay = delay;
    }

    @Override
    public void run() {
        atomicAccount.withdraw(100,delay);
    }

    public static void main(String[] args) {
        AtomicAccount a = new AtomicAccount(100);
        AtomicAccountMain t1 = new AtomicAccountMain(a,1000);
        AtomicAccountMain t2 = new AtomicAccountMain(a,0);

        t1.start();
        t2.start();
    }
}
