package com.practice.leetcode.editor.cn;
  
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3062 👎 0

public class MaximumSubarray{
  public static void main(String[] args) {
       Solution solution = new MaximumSubarray().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //f(i) = max{f(i-1) + num[i], num[i]}
        if (nums.length == 0) {
            return 0;
        }
        //第i个值得最大和
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] + dp[i-1] > nums[i]) {
                dp[i] = nums[i] + dp[i-1];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}