package com.gao.cn.set;

import com.gao.cn.avlTree.AVLTree;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/18 18:36
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }
}
