package com.practice.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/25 18:24
 */
public class RadixSort {
    public static void main(String[]args){
//        int[] a1 = new int[]{5,7,9,8,6,4,1,3,2};
        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[500000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(500000);
        }
        long start1 = System.currentTimeMillis();
        radixSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        System.out.println(Arrays.toString(a1));
    }

    private static void radixSort(int[] a) {
        int[][] postiveBucket = new int[10][a.length];
        int[][] negativeBucket = new int[10][a.length];
        int maxLenth = getMaxiumNumberCount(a);

    }


    private static int getMaxiumNumberCount(int[] a) {
        int i=0, max=a[0], min=a[0];
        for (int j=1; j<a.length; j++) {
            if (a[j] > max) {
                max = a[j];
            }
            if (a[j] < min) {
                min = a[j];
            }
        }
        int maxNumCount = getNumCount(max);
        int minNumCount = getNumCount(min);

        return Math.max(maxNumCount, minNumCount);
    }

    private static int getNumCount(int a) {
        int num = 1;
        while (a >> 1 != 0) {
            num++;
        }
        return num;
    }
}
