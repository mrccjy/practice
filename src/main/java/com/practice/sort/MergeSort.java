package com.practice.sort;

import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/24 10:50
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a1 = new int[]{5,7,9,8,6,4,1,3,2};
//        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
//        int[] a1 = new int[50000];
//        Random r1 = new Random(System.currentTimeMillis());
//        for (int i=0; i<a1.length-1; i++) {
//            a1[i] = r1.nextInt(50000);
//        }
        long start1 = System.currentTimeMillis();
        int[] sorted = mergeSort(a1, 0, a1.length-1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        for (int i : sorted) {
            System.out.print(i+",");
        }
    }

    private static int[] mergeSort(int[] a, int l, int r) {
        if (l == r) {
            return new int[]{a[l]};
        }
        int mid = l + (r-l)/2;
        int[] left = mergeSort(a, l, mid);
        int[] right = mergeSort(a, mid+1, r);
        int[] newArr = new int[left.length + right.length];

        int lIndex = 0, rIndex = 0, nIndex = 0, lLen = left.length, rLen = right.length;
        while (lIndex < lLen && rIndex < rLen) {
            if (left[lIndex] <= right[rIndex]) {
                newArr[nIndex] = left[lIndex];
                nIndex++;
                lIndex++;
            } else {
                newArr[nIndex] = right[rIndex];
                nIndex++;
                rIndex++;
            }
        }
        if (lIndex < lLen) {
            while (lIndex < lLen) {
                newArr[nIndex] = left[lIndex];
                nIndex++;
                lIndex++;
            }
        }
        if (rIndex < rLen) {
            while (rIndex < rLen) {
                newArr[nIndex] = right[rIndex];
                nIndex++;
                rIndex++;
            }
        }
        return newArr;
    }
}
