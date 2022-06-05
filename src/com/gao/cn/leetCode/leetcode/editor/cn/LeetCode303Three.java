package com.gao.cn.leetCode.leetcode.editor.cn;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/4 17:08
 */
public class LeetCode303Three {
    private int[] sum;

    public LeetCode303Three(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i < nums.length+1; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        LeetCode303Three obj = new LeetCode303Three(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
