package com.practice.leetcode.editor.cn;
  
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsIi{
  public static void main(String[] args) {
       Solution solution = new PermutationsIi().new Solution();
       solution.permuteUnique(new int[]{1,1,2});
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<Integer>> res = new ArrayList<>();
      HashMap<String, String> map = new HashMap<>();
      public List<List<Integer>> permuteUnique(int[] nums) {
          List<Integer> track = new ArrayList<>();
          HashMap<Integer, Integer> idxMap = new HashMap<>();
          backtrack(0, nums, track, idxMap);
          return res;
      }

      private void backtrack(int idx, int[] nums, List<Integer> track, HashMap<Integer, Integer> idxMap) {
          if (idx == nums.length && !exist(track)) {
              res.add(new ArrayList<>(track));
              return;
          }
          for (int i=0; i<nums.length; i++) {
              Integer n = nums[i];
              if (idxMap.containsKey(i)) {
                  continue;
              }
              idxMap.put(i,i);
              track.add(n);
              backtrack(idx+1, nums, track, idxMap);
              track.remove(track.size()-1);
              idxMap.remove(i);
          }
      }

      private boolean exist(List<Integer> track) {
          StringBuilder sb = new StringBuilder();
          track.stream().forEach(t -> sb.append(t));
          String s = sb.toString();
          if (map.containsKey(s)) {
              return true;
          } else {
              map.put(s,s);
          }
          return false;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}