package com.practice.leetcode.editor.cn;
  
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划

public class UniquePaths{
  public static void main(String[] args) {
       Solution solution = new UniquePaths().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        //因为走向只能往右和往下走，所以第i个格子的走法取决于左边格子i,j-1和上边格子i-1,j的走法之和，矩形边上所有格子的走法
        //都只有1中,得出f(i,j)=f(i,j-1)+f(i-1,j) 0<=i<m, 0<=j<n
        //初始化dp,左边和上边都为1
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            dp[i][0]=1;
        }
        for (int i=0; i<n; i++) {
            dp[0][i]=1;
        }
        //从左往右填表，从上往下填表
        for (int j=1; j<n; j++) {
            for (int i=1; i<m; i++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}