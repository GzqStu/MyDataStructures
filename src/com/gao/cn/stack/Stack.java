package com.gao.cn.stack;

/**
 * 自定义栈
 *
 * @author ：gaozhiqi
 * @date ：2022/5/27 9:57
 */
public interface Stack<E> {
    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 得到栈大小
     *
     * @return
     */
    int getSize();
}
