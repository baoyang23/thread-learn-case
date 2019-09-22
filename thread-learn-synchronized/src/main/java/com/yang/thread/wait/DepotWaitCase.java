package com.yang.thread.wait;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-21
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class DepotWaitCase {

    public static void main(String[] args) {

        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Customer consumer = new Customer(depot);
        producer.produce(60);
        producer.produce(120);
        consumer.comsume(90);
        consumer.comsume(150);
        producer.produce(110);
    }

}

class Depot {

    private int capacity;
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void product(int val){
        try {
            int left = val;
            while(left > 0){
                while (size >= capacity){
                    wait();
                }
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void comsume(int val){
        try{
            int left = val;
            while (left > 0){
                while (size <= 0){
                    wait();
                }
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "capacity : " + capacity + " ; actual size : " + size;
    }
}

class Producer {
    private Depot depot;

    public Producer(Depot depot){
        this.depot = depot;
    }

    public void produce(final int val){
        new Thread(() -> {
            depot.product(val);
        }).start();
    }
}

class Customer {

    private Depot depot;

    public Customer(Depot depot){
        this.depot = depot;
    }

    public void comsume(final int val){
        new Thread(() -> {
            depot.comsume(val);
        }).start();
    }
}
