package com.practice.leetcode.editor.cn;
  
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划

public class PalindromicSubstrings{
  public static void main(String[] args) {
       Solution solution = new PalindromicSubstrings().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        //dp[i][j] = dp[i+1][j-1] == true && char[i] == char[j]

        for (int j = 1; j <= chars.length - 1; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (chars[i] == chars[j]) {
                    if (i+1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = true && dp[i+1][j-1];
                    }
                }
            }
        }
        int trueNums = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j]) {
                    trueNums += 1;
                }
            }
        }
        return trueNums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}