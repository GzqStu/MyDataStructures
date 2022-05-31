package com.gao.cn.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
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
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 用栈实现前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        if (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 实现中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.println(root.e);
        preOrder(root.right);
    }

    /**
     * 实现后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.e);
    }

    /**
     * 用队列实现层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 查询二分搜索树最小元素
     *
     * @return
     */
    public E minNum() {
        if (root == null) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return minNum(root).e;
    }

    private Node minNum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minNum(node.left);
    }

    /**
     * 查询二分搜索树最大元素
     *
     * @return
     */
    public E maxNum() {
        if (root == null) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return maxNum(root).e;
    }

    private Node maxNum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxNum(node.right);
    }

    /**
     * 删除二分搜索树最小值，并返回删除的值
     *
     * @return
     */
    public E removeMin() {
        E minNum = minNum();
        root = removeMin(root);
        return minNum;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树最大值，并返回删除的值
     *
     * @return
     */
    public E removeMax() {
        E maxNum = maxNum();
        root = removeMax(root);
        return maxNum;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 删除二分搜索树中任意一个节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除某个节点，返回新的根节点
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {2, 4, 5, 8, 45, 34, 29, 67};
        /*int[] nums = {5,3,2,4,6,8};*/
        for (int num : nums) {
            bst.add(num);
        }
        System.out.println(bst.maxNum());
    }
}
