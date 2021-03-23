package com.practice.sort;

import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/23 17:33
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] a3 = new int[]{5,7,9,8,6,4,1,3,2};
//        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[50000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(50000);
        }
        long start1 = System.currentTimeMillis();
        bubbleSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
//        for (int i : a1) {
//            System.out.print(i+",");
//        }
    }

    private static void bubbleSort(int[] a) {
        for (int i=0; i< a.length-1; i++) {
            for (int j=0; j<a.length-1-i; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, j+1,a);
                }
            }
        }
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
