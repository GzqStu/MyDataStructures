package com.gao.cn.leetCode.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1207 👎 0


import java.util.PriorityQueue;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b)
        );
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int[] arr = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            arr[index] = pq.remove();
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,7,8,7,8,3,0,9};
        int k = 3;
        int[] ret = new Solution9().topKFrequent(nums,k);
        for(int i = 0 ;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
