package com.practice.leetcode.editor.cn;
  
//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -106 <= nums[i] <= 106 
// 
// Related Topics 树状数组 线段树 数组 动态规划

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence{
  public static void main(String[] args) {
       Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
       solution.findNumberOfLIS(new int[]{2,2,2,2,2});
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        //dp[i] = 到nums[0]-nums[i]最长递增子序列
        dp[0] = 1;
        Arrays.fill(cnt,1);
        int max = 1;
        for (int j=1; j<dp.length; j++) {
            for (int i=0; i<=j-1; i++) {
                if (nums[j] > nums[i]) {
                    if ((dp[i] + 1) == dp[j]) {
                        cnt[j] += cnt[i];
                    } else if ((dp[i] + 1) > dp[j]){
                        cnt[j] = cnt[i];
                    }
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                } else {
                    dp[j] = Math.max(dp[j], 1);
                }
            }
            max = Math.max(max, dp[j]);
        }
        int re = 0;
        for (int i=0; i<dp.length; i++) {
            if (max == dp[i]) {
                re += cnt[i];
            }
        }
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}