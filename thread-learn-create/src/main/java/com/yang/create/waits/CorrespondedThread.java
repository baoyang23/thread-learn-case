package com.yang.create.waits;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/****
 * author: BaoYang
 * data: 2023/3/25
 * desc:
 ***/
public class CorrespondedThread {

    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public static int maxSize = 1;

    static class Producer extends Thread {

        @Override
        public void run() {

            synchronized (queue) {
                // 最大，已经满了,不在生产数据，唤醒消费者去消费
                while (queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.add("生产数据1");
                // 唤醒消费者进行消费
                queue.notify();
            }

        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            synchronized (queue) {
                // 没有数据进行消费了，挂起
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 消费数据
                try {
                    String take = queue.take();
                    queue.notify();
                    System.out.println("取出数据: " + take);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {

        Consumer consumer = new Consumer();
        Producer producer = new Producer();

        consumer.start();
        producer.start();

    }

}
