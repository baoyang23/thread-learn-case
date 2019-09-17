package com.yang.atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  使用原子变量
 * @Author: Mu_Yi
 * @Date: 2019/9/15 23:24
 * @Version 1.0
 * @qq: 1411091515
 */
public class AtomicCounter {

    private AtomicInteger value = new AtomicInteger();

    public int getValue(){
        return value.get();
    }

    public int increment(){
        return value.incrementAndGet();
    }

    public int increment(int i){
        return value.addAndGet(i);
    }

    public int decrement(){
        return value.decrementAndGet();
    }

    public int decrement(int i){
        return value.addAndGet(-i);
    }
}
