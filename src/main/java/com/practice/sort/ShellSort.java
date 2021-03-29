package com.practice.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/24 15:09
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] a1 = new int[]{5,7,9,8,6,4,1,3,2};
//        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[50000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(50000);
        }
        long start1 = System.currentTimeMillis();
        shellSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        System.out.println(Arrays.toString(a1));
    }

    private static void shellSort(int[] a) {

        int step = a.length/2;

        while (step > 0) {
            for (int i = 0; i < step; i++) {
                for (int j=i+step; j < a.length; j = j + step) {
                    int pre = j - step;
                    while (pre >= 0 && a[pre+step] < a[pre]) {
                        swap(pre, pre+step, a);
                        pre = pre - step;
                    }
                }
            }
            step = step/2;
        }
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
