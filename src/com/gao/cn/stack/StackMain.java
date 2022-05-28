package com.gao.cn.stack;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/28 11:11
 */
public class StackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);


    }
}
