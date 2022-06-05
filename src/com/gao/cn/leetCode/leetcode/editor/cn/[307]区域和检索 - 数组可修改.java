package com.gao.cn.leetCode.leetcode.editor.cn;//给你一个数组 nums ，请你完成两类查询。
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 508 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray2 {

    private Integer[] data;
    public NumArray2(int[] nums) {
        data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
    }
    
    public void update(int index, int val) {
        if(index>=data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = val;
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
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
