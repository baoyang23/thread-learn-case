package com.yang.ylist.sums;

import java.util.concurrent.Callable;

/****
 * author: BaoYang
 * data: 2023/3/16
 * desc:
 ***/
public class SumTask implements Callable<Long> {

    int lo;
    int hi;
    int[] arr;

    public SumTask(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public Long call() throws Exception {
        long result = SumUtils.sumRange(arr, lo, hi);
        return new Long(result);
    }
}
