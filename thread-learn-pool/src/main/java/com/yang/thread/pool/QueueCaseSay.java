package com.yang.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-25
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class QueueCaseSay {

    public static void main(String[] args) throws Exception {

        // saySynchronousQueue();
        sayArrayBlockingQueue();

        // Executors

    }

    /**
     * 是这样 一种阻塞队列，其中每个 put 必须等待一个 take，反之亦然。同步队列没有任何内部容量，甚至连一个队列的容量都没有
     *
     * 这是一个内部没有任何容量的阻塞队列，任何一次插入操作的元素都要等待相对的删除/读取操作，否则进行插入操作的线程就要一直等待，反之亦然。
     *
     * 直接调用 add 方法会抛出异常 Exception in thread "main" java.lang.IllegalStateException: Queue full
     */
    public static void saySynchronousQueue(){
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        // synchronousQueue.add(new Object());

    }

    /**
     * 一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。新元素插入到队列的尾部，队列获取操作则是从队列头部开始获得元素。
     *
     * 这是一个典型的“有界缓存区”，固定大小的数组在其中保持生产者插入的元素和使用者提取的元素。
     *
     * 一旦创建了这样的缓存区，就不能再增加其容量。试图向已满队列中放入元素会导致操作受阻塞；试图从空队列中提取元素将导致类似阻塞。
     *
     * @throws Exception
     */
    public static void sayArrayBlockingQueue() throws Exception{
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        arrayBlockingQueue.put(new Object());
        arrayBlockingQueue.put(new Object());
        //  第三个就会一直被阻塞
        // arrayBlockingQueue.put(new Object());

    }

    /**
     * LinkedBlockingQueue是我们在ThreadPoolExecutor线程池中常应用的等待队列
     *
     * 由于它具有“无限容量”的特性，所以我还是将它归入了无限队列的范畴
     *
     * LinkedBlockingQueue的实现是基于链表结构，而不是类似ArrayBlockingQueue那样的数组。
     * 但实际使用过程中，您不需要关心它的内部实现，如果您指定了LinkedBlockingQueue的容量大小，
     * 那么它反映出来的使用特性就和ArrayBlockingQueue类似了。
     *
     * LinkedBlockingQueue的内部结构决定了它只能从队列尾部插入，从队列头部取出元素
     *
     */
    public static void sayLinkedBlockingQueue(){
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue(/*2*/);
        linkedBlockingQueue.add(new Object());
        linkedBlockingQueue.add(new Object());
        linkedBlockingQueue.add(new Object());


    }

}
