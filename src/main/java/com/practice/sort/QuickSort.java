package com.practice.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
//        int[] a = new int[1000000];
//        Random r = new Random(System.currentTimeMillis());
//        for (int i=0; i<a.length-1; i++) {
//            a[i] = r.nextInt(100000000);
//        }
//        long start = System.currentTimeMillis();
//        quicksort(0, a.length-1, a);
//        long end = System.currentTimeMillis();
//        System.out.println("time:" + (end - start) + "ms");
//        for (int i : a) {
//            System.out.print(i+",");
//        }

//        int[] a = new int[]{5,7,9,8,6,4,1,3,2};
//        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[1000000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(100000000);
        }
        long start1 = System.currentTimeMillis();
        quickSortDefault(0, a1.length-1, a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
//        for (int i : a1) {
//            System.out.print(i+",");
//        }
    }

    private static void quicksort(int l, int u, int[] a) {
        if (l >= u)
            return;
        int i = l+1, j = u, t = a[l];
        while (i <= j) {
            while (i <= u && a[i] <= t) {i++;}
            while (l <= j && a[j] > t) {j--;}
            if (i < j) {
                swap(i, j, a);
            }
        }
        swap(l, j, a);
        quicksort(l, j-1, a);
        quicksort(j+1, u, a);
    }

    private static void quickSortDefault(int l, int u, int[] a) {
        if (l >= u) {
            return ;
        }
        int key = a[l];
        int i = l, j=u;
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            if (i != j) {
                swap(i, j, a);
            }
            while (i < j && a[i] <= key) {
                i++;
            }
            if (i != j) {
                swap(i, j, a);
            }
        }
        a[i] = key;
        quickSortDefault(l, i-1, a);
        quickSortDefault(i+1, u, a);
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
