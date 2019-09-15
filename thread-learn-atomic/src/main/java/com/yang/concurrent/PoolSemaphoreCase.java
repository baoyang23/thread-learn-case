package com.yang.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/15 15:10
 * @Version 1.0
 * @qq: 1411091515
 */
public class PoolSemaphoreCase {

    private static final int MAX_VALUE = 5;

    private final Semaphore available = new Semaphore(MAX_VALUE,true);

    protected Object [] items = {"AAA","BBB","CCC","DDD","EEE"};
    protected boolean [] used = new boolean[MAX_VALUE];

    public static void main(String[] args) {
        final PoolSemaphoreCase poolSemaphoreCase = new PoolSemaphoreCase();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try{
                    Object o;
                    o = poolSemaphoreCase.getItem();
                    System.out.println(Thread.currentThread().getName() + " acquire " + o);
                    Thread.sleep(1000);
                    poolSemaphoreCase.putItem(o);
                    System.out.println(Thread.currentThread().getName() + " release " + o);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        for(int i=0;i<10;i++){
            Thread thread = new Thread(run,"t ==> " + i);
            thread.start();
        }

    }

    public Object getItem () throws Exception {
        available.acquire();
        return getNextAvailableItem();
    }

    /**
     * 放回数据;释放许可
     * @param x
     */
    public void putItem(Object x){
        if(markAsUnused(x)){
            available.release();
        }
    }

    protected synchronized Object getNextAvailableItem(){
        for(int i=0;i < MAX_VALUE;++i){
            if(!used[i]){
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(Object item){
        for(int i=0;i<MAX_VALUE;++i){
            if(item == items[i]){
                if(used[i]){
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
