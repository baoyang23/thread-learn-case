package com.yang.create.pools;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/****
 * author: BaoYang
 * data: 2023/3/15
 * desc:
 ***/
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.out.println(r.toString() + " is rejected");
    }

}
