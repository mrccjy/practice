package com.practice.leetcode.editor.cn;
  
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 513 👎 0

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence{
  public static void main(String[] args) {
       Solution solution = new PermutationSequence().new Solution();
      System.out.println(solution.getPermutation(9, 155915));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<Integer> res = new ArrayList<>();
      int num = 0;
      int k = 0;
    public String getPermutation(int n, int k) {
        this.k = k;
        List<Integer> track = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        backtrack(0, track, nums);
        StringBuilder sb = new StringBuilder();
        res.forEach(t -> sb.append(t));
        return sb.toString();
    }

    private int permu(int n) {
        int num = 1;
        while (n > 0) {
            num *= n--;
        }
        return num;
    }

      private void backtrack(int i, List<Integer> track, int[] nums) {
          if (i == nums.length) {
              num++;
              if (num == k) {
                  res.addAll(track);
              }
              return;
          }
          int num = permu(nums.length-i-1);
          for (int j = 0; j < nums.length; j++) {
              if (track.contains(nums[j])) {
                  continue;
              }
              if (num < k) {
                  k -= num;
                  continue;
              }
              track.add(nums[j]);
              backtrack(i+1, track, nums);
              if (num == k) {
                  break;
              }
              track.remove(Integer.valueOf(nums[j]));
          }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}