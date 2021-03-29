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
      System.out.println(solution.longestPalindrome("babad"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public String longestPalindrome(String s) {
//        if (s.length() == 0 || s.length() == 1) {
//            return s;
//        }
//        return cubeTimeAlgorithm(s);
//    }

    public String longestPalindrome(String s) {
       char[] c = s.toCharArray();
       int size = c.length;
       if (size < 2) {
           return s;
       }
       boolean[][] dp = new boolean[size][size];

        // 初始化
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
        }

       int start = 0;
       int len = 1;
       for (int j=1; j<size; j++) {
           for (int i=0; i<j; i++) {
               if (c[j] == c[i]) {
                   if ((j - i < 3)) {
                       dp[i][j] = true;
                   } else {
                       dp[i][j] = dp[i+1][j-1];
                   }
               } else {
                   dp[i][j] = false;
               }

               if (dp[i][j]) {
                   if (j - i + 1 > len) {
                       start = i;
                       len = j - i + 1;
                   }
               }
           }
       }

       return s.substring(start, start+len);
    }

      /**
       * 三次方算法，暴力
       * @param s
       * @return
       */
    public String cubeTimeAlgorithm(String s) {
        int n = s.length();
        int maxSize = 1;
        int begin = 0;
        char[] c = s.toCharArray();
        for (int i=0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                if (isPalinString(c, i, j) && (j-i+1) > maxSize) {
                    begin = i;
                    maxSize = j-i+1;
                }
            }
        }
        return s.substring(begin, begin+maxSize);
    }

    private boolean isPalinString(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}