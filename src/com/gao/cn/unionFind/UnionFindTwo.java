package com.gao.cn.unionFind;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/11 16:14
 */
public class UnionFindTwo implements UnionFind {
    private int[] parent;

    public UnionFindTwo(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
