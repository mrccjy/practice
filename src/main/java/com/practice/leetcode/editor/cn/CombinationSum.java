package com.practice.leetcode.editor.cn;
  
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法

import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
  public static void main(String[] args) {
       Solution solution = new CombinationSum().new Solution();
       solution.combinationSum(new int[]{2,3,6,7}, 7);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        List<Integer> track = new ArrayList<>();
        backtrack(0, candidates, track);
        return res;
    }

    private void backtrack(int sum, int[] candidates, List<Integer> track) {
        if (sum == target && !exist(track)) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=0; i<candidates.length; i++) {
            Integer num = candidates[i];
            if (sum+num > target) {
                continue;
            }
            track.add(num);
            backtrack(sum+num, candidates, track);
            track.remove(num);
        }
    }

    private boolean exist(List<Integer> track) {
        boolean exist = false;
        for (List<Integer> re : res) {
            List<Integer> copy = new ArrayList<>(re);
            for (Integer i : track) {
                if (!copy.contains(i)) {
                    exist = false;
                    break;
                } else {
                    copy.remove(i);
                    exist = true;
                }
            }
            if (exist) {
                break;
            }
        }
        return exist;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}