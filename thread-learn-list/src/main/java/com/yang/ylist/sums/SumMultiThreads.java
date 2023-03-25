package com.yang.ylist.sums;

import com.yang.ylist.utils.Utils;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/****
 * author: BaoYang
 * data: 2023/3/16
 * desc:
 ***/
public class SumMultiThreads {
    //100000000
    //10000000
    public final static int NUM = 10000000;

    public static long sum(int[] arr, ExecutorService executorService) throws Exception {

        long result = 0;
        int numThreads = arr.length / NUM > 0 ? arr.length / NUM : 1;
        SumTask[] sumTasks = new SumTask[numThreads];
        Future<Long>[] futures = new Future[numThreads];

        for (int i = 0; i < numThreads; i++) {
            sumTasks[i] = new SumTask(arr,(i + NUM) , ((i + 1 ) * NUM));
            futures[i] = executorService.submit(sumTasks[i]);
        }
        for (int i = 0; i < numThreads; i++) {
            result += futures[i].get();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        // 准备数组
        int[] arr = Utils.buildRandomIntArray(100000000);
        //获取线程数

        System.out.printf("The array length is: %d\n", arr.length);
        // 构建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //预热
        //((ThreadPoolExecutor)executor).prestartAllCoreThreads();

        Instant now = Instant.now();
        // 数组求和
        long result = sum(arr, executor);
        System.out.println("执行时间："+ Duration.between(now,Instant.now()).toMillis());

        System.out.printf("The result is: %d\n", result);

        executor.shutdown();

    }

}
