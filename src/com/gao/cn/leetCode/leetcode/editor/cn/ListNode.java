package com.gao.cn.leetCode.leetcode.editor.cn;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/29 16:15
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            ret.append(cur.val + "->");
            cur = cur.next;
        }
        ret.append(" Null");
        return ret.toString();
    }

    public ListNode sortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode cur = sortList(head.next);
        while(cur.next != null){
            if(head.val > cur.val){
                cur.next = head;
                head.next = null;
                head = cur;
            }
        }
        return head;
    }
}