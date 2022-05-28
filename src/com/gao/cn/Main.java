package com.gao.cn;

import com.gao.cn.array.Array;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.addLast(100);
        arr.addLast(100);
        System.out.println(arr);
        arr.removeElement(100);
        System.out.println(arr);
        arr.removeElements(100);
        System.out.println(arr);
    }
}
