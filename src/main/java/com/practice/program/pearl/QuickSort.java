package com.practice.program.pearl;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[1000000];
        Random r = new Random(System.currentTimeMillis());
        for (int i=0; i<a.length-1; i++) {
            a[i] = r.nextInt(100000000);
        }
        quicksort(0, a.length-1, a);
        for (int i : a) {
            System.out.print(i+",");
        }
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

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
