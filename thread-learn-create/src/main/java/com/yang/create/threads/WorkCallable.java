package com.yang.create.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/****
 * author: BaoYang
 * data: 2023/3/25
 * desc:
 ***/
public class WorkCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " --- 异步调用";
    }


    public static void main(String[] args) throws Exception {


        FutureTask<String> futureTask = new FutureTask<>(new WorkCallable());
        new Thread(futureTask).run();
        String s = futureTask.get();

        System.out.println("获取异步结果:" + s);
    }

}
