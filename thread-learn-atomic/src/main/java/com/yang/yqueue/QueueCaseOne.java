package com.yang.yqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mu_Yi
 * @Date: 2019/9/13 0:58
 * @Version 1.0
 * @qq: 1411091515
 */
public class QueueCaseOne {

    public static void main(String[] args) {

        // 队列  先进先出
        Queue<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.offer("Four");
        System.out.println(queue.poll());
    }

}
