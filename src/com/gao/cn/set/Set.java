package com.gao.cn.set;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/31 17:11
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean isEmpty();

    int getSize();

    boolean contains(E e);
}
