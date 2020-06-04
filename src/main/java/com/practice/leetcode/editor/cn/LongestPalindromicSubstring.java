package com.practice.leetcode.editor.cn;
  
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

public class LongestPalindromicSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
      System.out.println(solution.longestPalindrome("bb"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        return cubeTimeAlgorithm(s);
    }

      /**
       * 三次方算法，暴力。leetCode上直接超时
       * @param s
       * @return
       */
    public String cubeTimeAlgorithm(String s) {
        int maxSize = 0;
        String subString = null;
        String palinString = null;
        for (int i=0; i<s.length()-1; i++) {
            for (int j = i+1; j<=s.length(); j++) {
                subString = s.substring(i,j);
                if (isPalinString(subString) && subString.length() > maxSize) {
                    palinString = subString;
                    maxSize = subString.length();
                }
            }
        }
        return palinString;
    }

    private boolean isPalinString(String s) {
        for (int i=0; i<s.length()/2;i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            };
        }
        return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}