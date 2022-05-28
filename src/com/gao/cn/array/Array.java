package com.gao.cn.array;

/**
 * 自定义数组
 *
 * @author ：gaozhiqi
 * @date ：2022/5/27 9:57
 */
public class Array<E> {
    /**
     * 数组
     */
    private E[] data;
    /**
     * 数组大小
     */
    private int size;

    /**
     * 带参构造器
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造器
     */
    public Array() {
        //调用带参构造器
        this(10);
    }

    /**
     * 获取数组实际大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组最后一位添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组第一位添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);

    }

    /**
     * 获取索引位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. index is illegal");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 更新索引位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查询是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询某个元素的索引位置，如果不存在则返回-1
     * 默认数据中不存在重复元素
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在index索引位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed。index is illegal");
        }
        //进行数组扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 删除某个索引位置的元素,并且返回要删除的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete 。index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //进行缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素--不考虑存在重复数据的数组
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    /**
     * 删除某个元素--考虑存在重复数据的数组
     *
     * @param e
     */
    public void removeElements(E e) {
        int index = 0;
        while ((index = find(e)) != -1) {
            remove(index);
        }
    }

    /**
     * 重写toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
