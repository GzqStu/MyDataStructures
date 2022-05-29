package com.gao.cn;

import com.gao.cn.array.Array;
import com.gao.cn.queue.ArrayQueue;
import com.gao.cn.queue.LinkedListQueue;
import com.gao.cn.queue.LoopQueue;
import com.gao.cn.queue.Queue;
import com.gao.cn.stack.Stack;

public class Main {

    /**
     * 测试队列中opCount个数据增加和删除耗时
     *
     * @param queue
     * @param opCount
     * @return
     */
    private static Double testQueueTime(Queue<Integer> queue, int opCount) {
        Long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < opCount; i++) {
            queue.deQueue();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试栈中opCount个数据增加和删除耗时
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static Double testStackTime(Stack<Integer> stack, int opCount) {
        Long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试数组中opCount个数据增加和删除耗时
     *
     * @param array
     * @param opCount
     * @return
     */
    private static Double testArrayTime(Array<Integer> array, int opCount) {
        Long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {
            array.addLast(i);
        }
        for (int i = 0; i < opCount; i++) {
            array.removeLast();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        //查询数组队列耗时
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("数组队列: " + testQueueTime(arrayQueue, opCount));
        //查询循环队列耗时
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("循环队列: " + testQueueTime(loopQueue, opCount));
        //查询链表队列耗时
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("链表队列: " + testQueueTime(linkedListQueue, opCount));
        //查询数组栈耗时
       /* ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("数组栈: " + testStackTime(arrayStack, opCount));
        //查询链表栈耗时
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("链表栈: " + testStackTime(linkedListStack, opCount));*/
        //查询数组耗时
//        Array<Integer> array = new Array<>();
//        System.out.println("数组: " + testArrayTime(array, opCount));
    }
}
