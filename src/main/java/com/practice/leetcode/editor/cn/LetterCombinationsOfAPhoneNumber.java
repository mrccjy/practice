package com.practice.leetcode.editor.cn;
  
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法

import java.util.*;

public class LetterCombinationsOfAPhoneNumber{
  public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
       solution.letterCombinations("999");
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
      Map<Character, char[]> map = new HashMap(){{
          put('2', "abc".toCharArray());
          put('3', "def".toCharArray());
          put('4', "ghi".toCharArray());
          put('5', "jkl".toCharArray());
          put('6', "mno".toCharArray());
          put('7', "pqrs".toCharArray());
          put('8', "tuv".toCharArray());
          put('9', "wxyz".toCharArray());
      }};
    public List<String> letterCombinations(String digits) {

        //存储值为2-9
        char[] cArr = digits.toCharArray();
        //存储值为a-z
        List<Character> track = new ArrayList<>();
        backtrack(0, cArr, track);
        return res;
    }

    private void backtrack(int index, char[] nums, List<Character> track) {
        if (index == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : track) {
                sb.append(c);
            }
            if (sb.length() != 0) {
                res.add(sb.toString());
            }
            return;
        }
        char[] arr = map.get(nums[index]);
        for (Character c : arr) {
            track.add(c);
            backtrack(index+1, nums, track);
            track.remove(track.size() - 1);
        }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}