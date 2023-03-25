package com.yang.create.pools;

import com.yang.create.threads.WorkThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****
 * author: BaoYang
 * data: 2023/3/15
 * desc:
 ***/
public class SimpleThreadPool {

    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            WorkThread workThread = new WorkThread(" " + i);
            fixedThreadPool.execute(workThread);
        }

        fixedThreadPool.shutdown();
        while (!fixedThreadPool.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }

}
