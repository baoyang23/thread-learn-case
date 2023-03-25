package com.yang.ylist.utils;

import java.math.BigInteger;

/****
 * author: BaoYang
 * data: 2023/3/16
 * desc:
 ***/
public class CalcUtil {

    public static BigInteger calculateFactorial (BigInteger input) {
        BigInteger factorial = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE;
             i.compareTo(input) <= 0;
             i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
        }
        return factorial;
    }

}
