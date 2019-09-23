package com.yang.safety;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 *  说明线程干扰的问题
 * @Author: Mu_Yi
 * @Date: 2019/9/12 23:03
 * @Version 1.0
 * @qq: 1411091515
 */
public class BankAccount {

    private int number;

    private int balance;

    public BankAccount(){}

    public BankAccount(int number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * 加锁
     * @param amount
     */
    public /*synchronized*/ void deposit(int amount){
        synchronized (this){
            balance = balance + amount;
        }
    }

    /**
     * 加锁
     * @param amount
     */
    public /*synchronized*/ void withdraw(int amount){
        synchronized (this){
            balance = balance - amount;
        }
    }

    /**
     *  可以看到出现的结果还是有很多种  -2283700
     *  但是理想的结果应该还是初始化的
     *  如果想看到效果去掉 synchronized
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount(1,1000);
        Thread t1 = new Thread(new Depositor(account,100),"depositor");
        Thread t2 = new Thread(new Withdrawer(account,100),"withdrawer");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(account.getBalance());

      /*  HashMap<String,String> initMap = new HashMap<>();
        initMap.keySet()*/

        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<String> copySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<String> cSet = new ConcurrentSkipListSet<>();
        ConcurrentHashMap<String,String> cMap = new ConcurrentHashMap<>();

        ArrayBlockingQueue<String> aQueue = new ArrayBlockingQueue<String>(16);

    }

    static class Depositor implements Runnable{

        BankAccount account;

        int amount;

        public Depositor(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                account.deposit(amount);
            }
        }
    }

    static class Withdrawer implements Runnable {
        BankAccount account;

        int amount;

        public Withdrawer(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                account.withdraw(amount);
            }
        }
    }

}
