package com.gao.cn.binarySearchTree;

import java.util.Stack;

/**
 * 二分搜索树
 *
 * @author ：gaozhiqi
 * @date ：2022/5/30 15:14
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查询是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }

    }

    /**
     * 实现前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        if(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
    /**
     * 实现中序遍历
     */
    public void midOrder(){
        midOrder(root);
    }

    private void midOrder(Node root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.e);
        preOrder(root.right);
    }

    /**
     * 实现后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.e);
    }
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {2,4,5,8,45,34,29,67};
        for(int num:nums){
            bst.add(num);
        }
        bst.preOrder();
    }
}
