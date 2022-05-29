package com.gao.cn.recursion;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/29 17:48
 */
public class Practise {

    public static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(a, 0));
    }
}
