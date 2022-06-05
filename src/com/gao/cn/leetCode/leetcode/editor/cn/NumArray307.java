package com.gao.cn.leetCode.leetcode.editor.cn;//给定一个整数数组 nums，处理以下类型的多个查询:
//
// 
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= i <= j < nums.length 
// 最多调用 10⁴ 次 sumRange 方法 
// 
// Related Topics 设计 数组 前缀和 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray307 {

    public class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merge<E> merge;

        public SegmentTree(E[] arr, Merge<E> merge) {
            this.merge = merge;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E[]) new Object[arr.length * 4];
            buildSegmentTree(0, 0, data.length - 1);
        }

        /**
         * 在treeIndex的位置创建表示区间【l...r】的线段树
         *
         * @param treeIndex
         * @param l
         * @param r
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);
            tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index is illegal!");
            }
            return data[index];
        }

        /**
         * 返回一个完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
         *
         * @param index
         * @return
         */
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        /**
         * 返回一个完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
         *
         * @param index
         * @return
         */
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        /**
         * 返回区间【queryL,queryR】的值
         *
         * @param queryL
         * @param queryR
         * @return
         */
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("index is illegal !");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在以treeIndex为根的线段树中【l。。。r】的范围里，搜索区间【queryL...queryR】的值
         *
         * @param treeIndex
         * @param l
         * @param r
         * @param queryL
         * @param queryR
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merge.merge(leftResult, rightResult);
        }

        /**
         * 将index位置的值更新为e
         * @param index
         * @param e
         */
        public void set(int index ,E e){
            if(index<0 || index>=data.length){
                throw new IllegalArgumentException("index is illegal !");
            }
            data[index] = e;
            set(0,0,data.length-1,index,e);
        }

        /**
         * 在以treeIndex为根的线段树中更新index位置的值为e
         * @param treeIndex
         * @param l
         * @param r
         * @param index
         * @param e
         */
        private void set(int treeIndex, int l, int r, int index, E e) {
            if(l==r){
                tree[treeIndex] = e;
                return;
            }
            int mid = l+(r-l)/2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            if(index>=mid+1){
                set(rightChild,mid+1,r,index,e);
            }else{
                set(leftChild,l,mid,index,e);
            }
            tree[treeIndex] = merge.merge(tree[leftChild],tree[rightChild]);
        }
    }

    public interface Merge<E> {
        E merge(E a, E b);
    }

    private SegmentTree<Integer> segmentTree;

    public NumArray307(int[] nums) {
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
    }

    public void update(int index, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("is empty segmentTrr");
        }
        segmentTree.set(index,val);
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("is empty segmentTrr");
        }
        return segmentTree.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
