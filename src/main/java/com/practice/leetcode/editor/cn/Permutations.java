package com.practice.leetcode.editor.cn;
  
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permutations{
  public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<Integer>> res = new ArrayList<>();
      HashMap<String, String> map = new HashMap<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(0, nums, track);
        return res;
    }

      private void backtrack(int idx, int[] nums, List<Integer> track) {
          if (idx == nums.length && !exist(track)) {
              res.add(new ArrayList<>(track));
              return;
          }
          for (int i=0; i<nums.length; i++) {
              Integer n = nums[i];
              if (track.contains(n)) {
                  continue;
              }
              track.add(n);
              backtrack(idx+1, nums, track);
              track.remove(track.size()-1);
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