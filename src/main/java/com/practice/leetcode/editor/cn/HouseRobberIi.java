package com.practice.leetcode.editor.cn;
  
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划

public class HouseRobberIi{
  public static void main(String[] args) {
       Solution solution = new HouseRobberIi().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = nums[1];
        for (int i=2; i<=nums.length; i++) {
            if (i < nums.length) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i-1]);
            }
            if (i > 2) {
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i-1]);
            }
        }
        return Math.max(dp1[nums.length-1], dp2[nums.length]);
      }
    }
//leetcode submit region end(Prohibit modification and deletion)

}