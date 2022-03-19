package com.practice.leetcode.editor.cn;
  
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateIi{
  public static void main(String[] args) {
       Solution solution = new ContainsDuplicateIi().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);

            while ((right - left) >= k) {
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}