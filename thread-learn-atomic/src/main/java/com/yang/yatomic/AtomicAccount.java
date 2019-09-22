package com.yang.yatomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 0:38
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicAccount {

    private double balance;

    private AtomicLong atomicLong;

    public AtomicAccount(long money){
        atomicLong = new AtomicLong(money);
        System.out.println("Total Money : " + atomicLong);
    }

    public void deposit(long money){
        atomicLong.addAndGet(money);
    }

    public void deposit(long money,int delay){
        long oldValue = atomicLong.get();
        if(oldValue >= money){
            try{
                Thread.sleep(delay);
            }catch (Exception e){
                e.printStackTrace();
            }

            if(atomicLong.compareAndSet(oldValue,oldValue - money)){
                System.out.println(Thread.currentThread().getName() + "withdraw " + money + "successful" + atomicLong);
            }else {
                System.out.println(Thread.currentThread().getName() + "thread concurrent, withdraw failed!" + atomicLong);
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "balance is not enough,withdraw failed!" + atomicLong);
        }
    }

    public long get(){
        return atomicLong.get();
    }

    public AtomicAccount(double balance) {
        this.balance = balance;
        System.out.println("Total Money " + balance);
    }

    public void deposit(double money){
        balance = balance + money;
    }

    public synchronized void withdraw(double money,int delay){
        if(balance >= money){
            try{
                Thread.sleep(delay);
                balance = balance - money;
                System.out.println(Thread.currentThread().getName() + " withdraw " + money + "successful!" + balance);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "balance is not enough, withdraw failed!" + balance);
        }
    }

}
