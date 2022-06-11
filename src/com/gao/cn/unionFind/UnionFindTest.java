package com.gao.cn.unionFind;

import java.util.Random;

/**
 * @author ：gaozhiqi
 * @date ：2022/6/11 16:23
 */
public class UnionFindTest {

    private static double testUnionFind(UnionFind uf,int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for(int i = 0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }
        for(int i = 0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
        /**UnionFindOne uf1 = new UnionFindOne(size);
        System.out.println("UnionFindOne: "+testUnionFind(uf1,m)+" s");

        UnionFindTwo uf2 = new UnionFindTwo(size);
        System.out.println("UnionFindTwo: "+testUnionFind(uf2,m)+" s");*/

        /**UnionFindThree uf3 = new UnionFindThree(size);
        System.out.println("UnionFindThree: "+testUnionFind(uf3,m)+" s");

        UnionFindFour uf4 = new UnionFindFour(size);
        System.out.println("UnionFindFour: "+testUnionFind(uf4,m)+" s");

        UnonFindFive uf5 = new UnionFindFive(size);
        System.out.println("UnionFindFive: "+testUnionFind(uf5,m)+" s");*/

        UnionFindSix uf6 = new UnionFindSix(size);
        System.out.println("UnionFindSix: "+testUnionFind(uf6,m)+" s");
    }
}
