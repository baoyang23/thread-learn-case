package com.yang.lock;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 16:53
 * @Version 1.0
 * @qq: 1411091515
 */
public class SynchronizedBenchmarkCase implements Counter {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public long getValue() {
        return 0;
    }

    @Override
    public synchronized void increment() {
        count ++;
    }
}
