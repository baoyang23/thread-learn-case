package com.yang.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  不公平重入锁
 *
 * @Author: Mu_Yi
 * @Date: 2019/9/15 16:54
 * @Version 1.0
 * @qq: 1411091515
 */
public class ReentrantLockUnfairBeanchmarCase implements Counter {

    private volatile long count = 0;

    private Lock lock;

    public ReentrantLockUnfairBeanchmarCase(){
        lock = new ReentrantLock(false);
    }

    @Override
    public long getValue() {
        return count;
    }

    @Override
    public void increment() {

        lock.lock();
        try{
            count ++;
        } finally {
            lock.unlock();
        }

    }
}
