package com.gao.cn.leetCode.leetcode.editor.cn;//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1858 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {
    public int longestValidParentheses(String s) {
        int sum = 0;
        if (s == null || s.equals("")) {
            return 0;
        }
        int sum1 = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char topChar = stack.peek();
                if (topChar == '(') {
                    if (c == ')') {
                        stack.pop();
                        sum += 2;
                    } else {
                        stack.push(c);
                    }
                } else if (topChar == ')') {
                    stack.push(c);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("()(()"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
