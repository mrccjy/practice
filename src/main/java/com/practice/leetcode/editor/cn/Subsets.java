package com.practice.leetcode.editor.cn;
  
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1158 👎 0

import java.util.ArrayList;
import java.util.List;

public class Subsets{
  public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        for (int i=0; i<=nums.length; i++) {
            backtrack(0, i, nums, track);
        }
        return res;
    }

      private void backtrack(int idx, int size, int[] nums, List<Integer> track) {
          if (track.size() == size) {
              if (track.isEmpty()) {
                  res.add(new ArrayList<>());
              } else {
                  res.add(new ArrayList<>(track));
              }
              return;
          }
          for (int i=idx; i<nums.length; i++) {
              if (track.contains(nums[i])) {
                  continue;
              }
              if (size - track.size() > nums.length - i ) {
                  continue;
              }
              track.add(nums[i]);
              backtrack(i+1, size, nums, track);
              track.remove(Integer.valueOf(nums[i]));
          }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}