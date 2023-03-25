package com.yang.ylist.sums;

import com.yang.ylist.utils.Utils;

import java.time.Duration;
import java.time.Instant;

/****
 * author: BaoYang
 * data: 2023/3/16
 * desc:
 ***/
public class SumSequential {

    public static long sum(int[] arr){

        return SumUtils.sumRange(arr,0,arr.length);
    }

    public static void main(String[] args) {

        int[] array = Utils.buildRandomIntArray(100000000);
        System.out.println("array长度: " + array.length);

        Instant now = Instant.now();
        long sum = sum(array);
        System.out.println("执行时间： " + Duration.between(now, Instant.now()).toMillis());
        System.out.println("获取结果：  " + sum);
    }

}
