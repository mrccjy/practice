package com.practice.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/3/25 9:42
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] a1 = new int[]{5,7,9,8,6,4,1,3,2};
        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] a1 = new int[50000];
        Random r1 = new Random(System.currentTimeMillis());
        for (int i=0; i<a1.length-1; i++) {
            a1[i] = r1.nextInt(50000);
        }
        long start1 = System.currentTimeMillis();
        heapSort(a1);
        long end1 = System.currentTimeMillis();
        System.out.println("time1:" + (end1 - start1) + "ms");
        System.out.println(Arrays.toString(a1));
    }

    private static void heapSort(int[] a) {
        buildHeap(a);
        //因为调整过后的堆第一个元素是最大的，把第一个元素和最后一个元素调换位置
        //然后继续调整[0, length-1]位置上的堆为大顶堆，依次完成排序
        for (int tail=a.length-1; tail>0; tail--) {
            swap(0, tail, a);
            //调整时，以对顶作为首次调整的父节点，adjustHeap会依次往下调整
            adjustHeap(a, 0, tail);
        }
    }

    private static void buildHeap(int[] a) {
        //从最右一个非叶子结点开始调整
        for (int i=a.length/2 - 1; i>= 0; i--) {
            adjustHeap(a, i, a.length);
        }
    }

    /**
     * 调整堆的前提是该节点以下的堆已经整体上是一个大顶堆，而首次调整时是自下而上调整的，所以不影响
     * @param a
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] a, int i, int length) {
        //调整完爷爷节点就往下调整父亲节点，一步一步往下调整
        for (int j=2*i+1; j<length; j = 2*j+1) {
            int parent = a[i];
            //有右节点的情况先匹配左右儿子节点哪个大，取大的那一个
            if (j+1 < length && a[j+1] > a[j]) {
                j = j+1;
            }
            if (parent < a[j]) {
                //大的子节点跟小的父节点交换位置
                swap(i, j, a);
                //把子节点指针设置为父节点指针(即往下调整)
                i = j;
            }
        }
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
