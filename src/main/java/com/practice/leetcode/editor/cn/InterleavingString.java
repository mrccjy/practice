package com.practice.leetcode.editor.cn;
  
//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
//
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划

public class InterleavingString{
  public static void main(String[] args) {
       Solution solution = new InterleavingString().new Solution();
      System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //f(i,j)表示s1前i个元素与s2前j个元素能组成s3前p个元素交叉组合，p=i+j
        //f(i,j)=[f(i-1,j) and s3[i+j-1] == s1[i]] or [f(i,j-1) and s3[i+j-1] == s2[j]]
        if (s1.length()+s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i=0; i<=s1.length(); i++) {
            for (int j=0; j<=s2.length(); j++) {
                if (i>0) {
                    dp[i][j] = (dp[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1)));
                }
                if(j>0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}