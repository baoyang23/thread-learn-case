package com.yang.ylist.sums;

/****
 * author: BaoYang
 * data: 2023/3/16
 * desc:
 ***/
public class SumUtils {


    public static long sumRange(int []arr, int lo, int hi ){

        long result = 0;

        for (int i = lo; i < hi; i++) {
            result += arr[i];
        }

        return result;
    }

}
