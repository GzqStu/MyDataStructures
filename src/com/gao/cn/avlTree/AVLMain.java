package com.gao.cn.avlTree;

import com.gao.cn.map.BSTMap;
import com.gao.cn.util.FileOperation;

import java.util.ArrayList;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/12 18:55
 */
public class AVLMain {

    /**
     * 测试AVL树，是否是二分搜索树，以及平衡二叉树
     */
    private static void testIsAVLTree() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());
            for(String word:words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()){
                    throw new RuntimeException("Error");
                }
            }
        }
        System.out.println("AVLTree designer is success!");
    }

    /**
     * 测试二分搜索树性能
     */
    private static void testBST() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            //Test BST
            long startTime = System.nanoTime();
            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }
            for (String word : words) {
                bst.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST : " + time + " s");
        }
    }

    /**
     * 测试AVL树性能
     */
    private static void testAVLTree() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            //Test BST
            long startTime = System.nanoTime();
            AVLTree<String, Integer> bst = new AVLTree<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }
            for (String word : words) {
                bst.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVLTree : " + time + " s");
        }
    }

    public static void main(String[] args) {
        //测试AVL树，是否是二分搜索树，以及平衡二叉树
        testIsAVLTree();
        //测试二分搜索树性能
        /*testAVLTree();*/
        //测试二分搜索树性能
        /*testBST();*/
    }
}
