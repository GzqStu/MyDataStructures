package com.gao.cn.linkedList;

/**
 * 自定义链表
 *
 * @author ：gaozhiqi
 * @date ：2022/5/28 21:13
 */
public class LinkedList<E> {

    private Node head;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public LinkedList() {
        this.head = null;
        size = 0;
    }

    /**
     * 获取链表元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头加上一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    /**
     * 给链表加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed.index is illegal ");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }
}