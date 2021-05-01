package com.practice.leetcode.editor.cn;
  
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 574 👎 0

import java.util.ArrayList;
import java.util.List;

public class Combinations{
  public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
       solution.combine(4, 2);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<Integer>> res = new ArrayList<>();
      int k = 0;
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        this.k = k;
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(0, arr, track);
        return res;
    }

      private void backtrack(int index, int[] arr, List<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (track.contains(arr[i])) {
                continue;
            }
            track.add(arr[i]);
            backtrack(i + 1, arr, track);
            track.remove(Integer.valueOf(arr[i]));
        }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}