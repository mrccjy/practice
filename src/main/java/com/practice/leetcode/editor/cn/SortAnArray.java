package com.practice.leetcode.editor.cn;
  
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -5 * 104 <= nums[i] <= 5 * 104 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 527 👎 0

public class SortAnArray{
  public static void main(String[] args) {
       Solution solution = new SortAnArray().new Solution();
       solution.sortArray(new int[]{0,1});
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        return quickSort(0, nums.length-1, nums);
    }

    private int[] quickSort(int l, int r, int[] nums) {
        if (l >= r) {
            return nums;
        }
        int i = l+1, j = r;
        int slot = nums[l];
        while (i <= j) {
            while (i <= j && nums[i] <= slot) i++;
            while (j >= i && nums[j] > slot) j--;
            if (i < j) {
                swap(i, j, nums);
            }
        }
        swap(l, j, nums);
        quickSort(l, j-1, nums);
        quickSort(j+1, r, nums);
        return nums;
    }
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}