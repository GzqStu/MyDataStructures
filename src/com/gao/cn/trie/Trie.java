package com.gao.cn.trie;

import java.util.TreeMap;

/**
 * Trie树
 * @author ：gaozhiqi
 * @date ：2022/6/5 10:35
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie(){
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for(int i = 0;i<word.length();i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
