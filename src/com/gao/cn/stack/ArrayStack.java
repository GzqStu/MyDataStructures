package com.gao.cn.stack;

import com.gao.cn.array.Array;

/**
 * 实现栈
 *
 * @author ：gaozhiqi
 * @date ：2022/5/28 10:46
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * 动态数组
     */
    private Array<E> array;

    /**
     * 含参构造器
     *
     * @param capacity 数组容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 无参构造器
     */
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 重写toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
