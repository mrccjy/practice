package com.practice.program.pearl;
/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2020/6/2 10:10
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArr = {0, 1, 2};
        System.out.println(binarySearch(sortedArr, 0));
        System.out.println(binarySearch(sortedArr, 1));
        System.out.println(binarySearch(sortedArr, 2));
        System.out.println(binarySearch(sortedArr, -1));
        System.out.println(binarySearch(sortedArr, 3));
        int[] sortedArr1 = {0, 1, 2, 3};
        System.out.println(binarySearch(sortedArr, -1));
        System.out.println(binarySearch(sortedArr1, 0));
        System.out.println(binarySearch(sortedArr1, 1));
        System.out.println(binarySearch(sortedArr1, 2));
        System.out.println(binarySearch(sortedArr1, 3));
        System.out.println(binarySearch(sortedArr1, 4));
    }

    /**
     *  二分搜索
     * @param arr 有序数组
     * @param dest  搜索目标值
     * @return
     */
    public static int binarySearch(int[] arr, int dest) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int up = arr.length - 1;
        int down = 0;
        while (down <= up) {
            //防止上界加下界溢出
            int mid = down + ((up-down)>>1);
            if (arr[mid] == dest) {
                return mid;
            } else if (arr[mid] > dest) {
                up = mid - 1;
            } else {
                down = mid + 1;
            }
        }
        return -1;
    }
}
