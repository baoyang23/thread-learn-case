package com.yang.concurrent;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 16:14
 * @Version 1.0
 * @qq: 1411091515
 */
public class ExchangerCase {

    private static final Exchanger ex = new Exchanger();

    class DataProduct implements Runnable {

        private List list = new ArrayList();

        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println("生产数据一个;耗时一秒");
                list.add(new Date());
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            try{
                list = (List) ex.exchange(list);
            }catch (Exception e){
                e.printStackTrace();
            }

            for(Iterator iterator = list.iterator();iterator.hasNext();){
                System.out.println("Product  " + iterator.next());
            }

        }
    }

    class DataConsumer implements Runnable {

        private List list = new ArrayList();

        @Override
        public void run() {

            for(int i=0;i<5;i++){
                list.add("这是一条消息");
            }

            try {
                list = (List) ex.exchange(list);
            } catch (Exception e){
                e.printStackTrace();
            }

            for(Iterator iterator = list.iterator();iterator.hasNext();){
                Date date = (Date) iterator.next();
                System.out.println("consumer:" + date);
            }
        }
    }

    public static void main(String[] args) {
        ExchangerCase et = new ExchangerCase();
        new Thread(et.new DataProduct()).start();
        new Thread(et.new DataConsumer()).start();
    }
}
