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
        int[] a1 = new int[]{-999, 35, -1026, 3056, 0, -1, 3, 0, 156};
//        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
//        int[] a1 = new int[500000];
//        Random r1 = new Random(System.currentTimeMillis());
//        for (int i=0; i<a1.length-1; i++) {
//            a1[i] = r1.nextInt(500000);
//        }
        long start1 = System.currentTimeMillis();
        radixSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        System.out.println(Arrays.toString(a1));
    }

    private static void radixSort(int[] a) {

        int maxLenth = getMaxiumNumberCount(a);

        for (int i=0, radix=1, mod=10; i<maxLenth; radix *= 10, mod *= 10, i++) {
            int[][] positiveBucket = new int[10][a.length];
            int[][] negativeBucket = new int[10][a.length];
            int[] positiveOrder = new int[10];
            int[] negativeOrder = new int[10];

            for (int j=0; j< a.length; j++) {
                if (a[j] < 0) {
                    int index = Math.abs((a[j] % mod) / radix);
                    negativeBucket[index][negativeOrder[index]] = a[j];
                    //设置下一个槽位
                    negativeOrder[index] += 1;
                } else {
                    int index = (a[j] % mod) / radix;
                    positiveBucket[index][positiveOrder[index]] = a[j];
                    positiveOrder[index] += 1;
                }

            }

            int aPosi = 0;
            //取负数区间数据，先从后往前遍历
            for (int nj=negativeBucket.length -1; nj >=0; nj--) {
                if (negativeOrder[nj] != 0) {
                    for (int njj=0; njj< negativeOrder[nj]; njj++) {
                        a[aPosi] = negativeBucket[nj][njj];
                        aPosi++;
                    }
                }
            }
            //取正数区间数据，从前往后遍历
            for (int pj=0; pj < positiveBucket.length; pj++) {
                if (positiveOrder[pj] != 0) {
                    for (int pjj= 0; pjj<positiveOrder[pj]; pjj++) {
                        a[aPosi] = positiveBucket[pj][pjj];
                        aPosi++;
                    }
                }
            }
        }

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
        while ((a = a/10) != 0) {
            num++;
        }
        return num;
    }
}
