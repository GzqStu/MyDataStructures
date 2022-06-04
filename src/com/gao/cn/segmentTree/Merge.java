package com.gao.cn.segmentTree;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/4 15:28
 */
public interface Merge<E> {
    E merge(E a, E b);
}
