package com.yang.yqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 1:00
 * @Version 1.0
 * @qq: 1411091515
 */
public class PriorityQueueCase {

    public static void main(String[] args) {
        // 栈
        Queue<String>  queue = new PriorityQueue<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.offer("Four");
        //  弹栈
        System.out.println(queue.poll());
    }

}
