package com.gao.cn.unionFind;

/**
 * 定义并查集接口
 */
public interface UnionFind {
    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

    int getSize();
}
