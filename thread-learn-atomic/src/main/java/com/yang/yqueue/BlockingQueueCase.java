package com.yang.yqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 1:05
 * @Version 1.0
 * @qq: 1411091515
 */
public class BlockingQueueCase {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Product product = new Product(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);

        new Thread(product).start();
        new Thread(c1).start();;
        new Thread(c2).start();
    }

    static class Product implements Runnable{

        private final BlockingQueue<String> queue;

        public Product(BlockingQueue<String> queue){ this.queue = queue;}

        String produce(){
            String temp = "" + (char) ('A' + (int)(Math.random()*26));
            System.out.println("product " + temp);
            return temp;
        }

        @Override
        public void run() {
            try{
                for(int i=0;i<100;i++){
                    queue.put(produce());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private final BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue){this.queue = queue;}

        @Override
        public void run() {
           try {
               for(int i=0;i<100;i++){
                   consume(queue.take());
               }
           }catch (Exception e){
               e.printStackTrace();
           }
        }

        void consume(String x){
            System.out.println("Thread Number :" + Thread.currentThread().getName() + "consume " + x);
        }
    }
}
