package com.gao.cn.leetCode.leetcode.editor.cn;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/4 17:08
 */
public class LeetCode303Two {
    private Integer[] data;

    public LeetCode303Two(int[] nums) {
        data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (data == null) {
            throw new IllegalArgumentException("is empty array");
        }
        if (left < 0 || left >= data.length || right < 0 || right >= data.length || left > right) {
            throw new IllegalArgumentException("left and right range is illegal");
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        LeetCode303Two obj = new LeetCode303Two(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
