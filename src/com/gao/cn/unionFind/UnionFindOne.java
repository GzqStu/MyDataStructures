package com.gao.cn.unionFind;

/**
 *
 * @author ：gaozhiqi
 * @date ：2022/6/11 15:47
 */
public class UnionFindOne implements UnionFind {

    /**
     * 存储数据所属的集合
     */
    private int[] id;

    public UnionFindOne(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p和元素q是否所属一个集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}
