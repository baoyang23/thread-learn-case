package com.yang.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 16:34
 * @Version 1.0
 * @qq: 1411091515
 */
public class FutureTaskCase {

    public static void main(String[] args) {

        Callable pAccount = new PrivateAccount();
        FutureTask futureTask = new FutureTask(pAccount);
        Thread pAccountThread = new Thread(futureTask);
        System.out.println("future task start at " + System.nanoTime());
        pAccountThread.start();

        System.out.println("main thread doing something else here. ");
        int totalMoney = new Random().nextInt(100000);
        System.out.println("You have  " + totalMoney + " in your other Accounts");
        System.out.println(" Waiting for data from Private Account ");

        // 判断 futureTask 是否还在done
        while (!futureTask.isDone()){
            try{
                Thread.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("future task ends at " + System.nanoTime());
            Integer privataAccountMoney = null;

            try {
                // 获取出 futureTask 中的值
                privataAccountMoney = (Integer) futureTask.get();
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("The total money you have is " + (totalMoney + privataAccountMoney.intValue()));
        }
    }

    /**
     * 创建一个 Callable类;模拟计算一个私有的账户中的金额
     */
    static class PrivateAccount implements Callable {

        Integer totalMoney;

        @Override
        public Object call() throws Exception {
            Thread.sleep(5000);
            totalMoney = new Integer(new Random().nextInt(10000));
            System.out.println(" You have " + totalMoney + " in your private Account");
            return totalMoney;
        }
    }

}
