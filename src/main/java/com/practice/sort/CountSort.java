package com.practice.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/25 11:27
 */
public class CountSort {
    public static void main(String[]args){
//        int[] a1 = new int[]{5,7,9,8,6,4,1,3,2};
        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[500000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(500000);
        }
        long start1 = System.currentTimeMillis();
        int[] b = countSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        System.out.println(Arrays.toString(b));
    }
    public static int[] countSort(int[]a) {
        int max = a[0], min = a[0];
        //找出最大值最小值，用于计算k数组大小
        for (int i=1; i< a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        //初始化k数组大小，max-min+1个空间
        //k数组：以a数组的值作为下标，a数组中每个元素出现个数总和作为值
        int[] k = new int[max-min+1];
        int[] newArr = new int[a.length];

        for (int i=0; i<a.length; i++) {
            //取出k数组中以a[i]为值的下标进行个数相加
            k[a[i]-min] += 1;
        }

        //计算出k数组中每个下标值中最后一位应该存放的位置：k[i] = k[i] + k[i-1]方式
        for (int i=1; i<k.length; i++) {
            k[i] = k[i] + k[i-1];
        }

        //从后往前遍历a数组，根据k数组的值定的下标就是newArr数组应该存的下标，
        // 设置到新数组newArr除，并且对k数组改位置上的值-1操作（-1意味着下次遇到这个数就存到前一个下标出）
        for (int i=a.length-1; i>=0; i--) {
            int kKey = a[i];
            int newIndex = k[kKey-min]-1;
            newArr[newIndex] = a[i];
            //再次遇到该值时应该保存在前一个下标，所以减一操作
            k[kKey-min] = newIndex;
        }
        return newArr;
    }
}
