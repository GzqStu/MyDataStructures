package com.gao.cn.unionFind;

/**
 * 在UnionFindThree的基础下基于树的深度去进行优化
 *
 * @author ：gaozhiqi
 * @date ：2022/6/11 16:14
 */
public class UnionFindFour implements UnionFind {
    private int[] parent;
    private int[] rank;//rank[i] 表示以i为根的集合所表示的树的层数

    public UnionFindFour(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
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
