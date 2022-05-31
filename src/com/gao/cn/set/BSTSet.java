package com.gao.cn.set;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/31 17:16
 */
public class BSTSet <E extends Comparable<E>> implements Set<E>{

    private BSTSet<E> bst;
    public BSTSet(){
        bst = new BSTSet<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
