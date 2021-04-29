package com.practice.leetcode.editor.cn;
  
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法

import java.util.*;

public class CombinationSumIi{
  public static void main(String[] args) {
       Solution solution = new CombinationSumIi().new Solution();
      solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<Integer>> res = new ArrayList<>();
      HashMap<String, String> map = new HashMap<>();
      int target = 0;
      public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          this.target = target;
          //下标
          List<Integer> track = new ArrayList<>();
          Arrays.sort(candidates);
          backtrack(0,0, candidates, track);
          return res;
      }

      private void backtrack(int index, int sum, int[] candidates, List<Integer> track) {
          if (sum == target && !exist(track)) {
              res.add(new ArrayList<>(track));
              return;
          }
          for (int i=index; i<candidates.length; i++) {
              Integer num = candidates[i];
              if (sum+num > target) {
                  continue;
              }
              track.add(candidates[i]);
              backtrack(i+1,sum+num, candidates, track);
              track.remove(track.size()-1);
          }
      }

      private boolean exist(List<Integer> track) {
          StringBuilder sb = new StringBuilder();
          Collections.sort(track);
          track.stream().forEach(t -> sb.append(t));
          String s = sb.toString();
          if (map.containsKey(s)) {
              return true;
          } else {
              map.put(s, s);
              return false;
          }
      }

  }
//leetcode submit region end(Prohibit modification and deletion)

}