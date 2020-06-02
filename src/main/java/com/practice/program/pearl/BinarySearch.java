package com.practice.program.pearl;
/**
 *  @description: 对有序数组进行二分搜索
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
        System.out.println("==================================");
        int[] sortedArr1 = {0, 1, 2, 3};
        System.out.println(binarySearch(sortedArr, -1));
        System.out.println(binarySearch(sortedArr1, 0));
        System.out.println(binarySearch(sortedArr1, 1));
        System.out.println(binarySearch(sortedArr1, 2));
        System.out.println(binarySearch(sortedArr1, 3));
        System.out.println(binarySearch(sortedArr1, 4));
        System.out.println("==================================");
        int[] sortedArr2 = {0, 1, 1};
        System.out.println(binarySearchFirst(sortedArr2, 0));
        System.out.println(binarySearchFirst(sortedArr2, 1));
        System.out.println(binarySearchFirst(sortedArr2, 2));
        System.out.println(binarySearchFirst(sortedArr2, -1));
        System.out.println(binarySearchFirst(sortedArr2, 3));
        System.out.println("==================================");
        int[] sortedArr3 = {1, 1, 1};
        System.out.println(binarySearchFirst(sortedArr3, 0));
        System.out.println(binarySearchFirst(sortedArr3, 1));
        System.out.println(binarySearchFirst(sortedArr3, 2));
        System.out.println(binarySearchFirst(sortedArr3, -1));
        System.out.println(binarySearchFirst(sortedArr3, 3));
        System.out.println("==================================");
        int[] sortedArr4 = {0, 1, 1, 3};
        System.out.println(binarySearchFirst(sortedArr4, 0));
        System.out.println(binarySearchFirst(sortedArr4, 1));
        System.out.println(binarySearchFirst(sortedArr4, 2));
        System.out.println(binarySearchFirst(sortedArr4, -1));
        System.out.println(binarySearchFirst(sortedArr4, 3));
        System.out.println("==================================");
        int[] sortedArr5 = {1, 1, 1, 1};
        System.out.println(binarySearchFirst(sortedArr5, 0));
        System.out.println(binarySearchFirst(sortedArr5, 1));
        System.out.println(binarySearchFirst(sortedArr5, 2));
        System.out.println(binarySearchFirst(sortedArr5, -1));
        System.out.println(binarySearchFirst(sortedArr5, 3));
        System.out.println("==================================");
        int[] sortedArr6 = {1, 1, 1, 3};
        System.out.println(binarySearchFirst(sortedArr6, 0));
        System.out.println(binarySearchFirst(sortedArr6, 1));
        System.out.println(binarySearchFirst(sortedArr6, 2));
        System.out.println(binarySearchFirst(sortedArr6, -1));
        System.out.println(binarySearchFirst(sortedArr6, 3));
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

    /**
     *  二分搜索,返回数组中第一个目标下标
     * @param arr 有序数组
     * @param dest  搜索目标值
     * @return
     */
    public static int binarySearchFirst(int[] arr, int dest) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int up = arr.length - 1;
        int down = 0;
        int index = -1;
        while (down <= up) {
            //防止上界加下界溢出
            int mid = down + ((up-down)>>1);
            if (arr[mid] == dest) {
                //记录当前找到的下标
                index = mid;
                //向左继续寻找符合条件的下标
                up = mid - 1;
            } else if (arr[mid] > dest) {
                up = mid - 1;
            } else {
                down = mid + 1;
            }
        }
        return index;
    }
}
