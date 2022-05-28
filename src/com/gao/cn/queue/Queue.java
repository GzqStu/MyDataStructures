package com.gao.cn.queue;

/**
 * 自定义队列
 *
 * @author ：gaozhiqi
 * @date ：2022/5/27 9:57
 */
public interface Queue<E> {
    /**
     * 获取元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E deQueue();

    /**
     * 获取队首元素
     *
     * @return
     */
    E getFront();
}
