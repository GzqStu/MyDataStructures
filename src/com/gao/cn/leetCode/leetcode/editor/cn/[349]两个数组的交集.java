package com.gao.cn.leetCode.leetcode.editor.cn;//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 551 👎 0


import java.util.Iterator;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int num1 : nums2) {
            if (set.contains(num1)) {
                set1.add(num1);
            }
        }
        int[] ret = new int[set1.size()];
        int index = 0;
        Iterator<Integer> iterator = set1.iterator();
        while(iterator.hasNext()){
            ret[index] = iterator.next();
            index++;
            iterator.remove();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,8,6,0,3};
        int[] nums2 ={0,4,5};
        int[] ret = new Solution6().intersection(nums1,nums2);
        for(int i = 0;i<ret.length;i++){
            System.out.println("@@@: "+ret[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
