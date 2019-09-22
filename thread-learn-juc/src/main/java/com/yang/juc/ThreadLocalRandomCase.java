package com.yang.juc;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/16 23:51
 * @Version 1.0
 * @qq: 1411091515
 */
public class ThreadLocalRandomCase {

    public static void main(String[] args) {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i=0;i<10;i++){
            System.out.println(random.nextInt(5));
        }

    }

}
