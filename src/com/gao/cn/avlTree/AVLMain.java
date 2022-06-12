package com.gao.cn.avlTree;

import com.gao.cn.set.BSTSet;
import com.gao.cn.util.FileOperation;

import java.util.ArrayList;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/12 18:55
 */
public class AVLMain {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: "+words.size());
            AVLTree<String,Integer> map = new AVLTree<>();
            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + "s");
        }
    }
}
