package com.gao.cn.set;

import com.gao.cn.linkedList.LinkedList;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/31 17:55
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }
}
