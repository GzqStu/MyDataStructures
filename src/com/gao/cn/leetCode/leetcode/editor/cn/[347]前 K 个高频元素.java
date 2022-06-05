
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


import com.gao.cn.queue.PriorityQueue;

import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution8 {
    private class Freq implements Comparable<Freq> {
        public int e;
        public int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            }
            return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(k) > pq.getFront().freq) {
                pq.deQueue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        int[] arr = new int[pq.getSize()];
        int index = 0;
        while (!pq.isEmpty()) {
            arr[index] = pq.deQueue().e;
            index++;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

