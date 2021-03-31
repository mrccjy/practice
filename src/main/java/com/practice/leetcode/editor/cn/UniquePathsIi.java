package com.practice.leetcode.editor.cn;
  
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划

import java.util.HashMap;
import java.util.HashSet;

public class UniquePathsIi{
  public static void main(String[] args) {
       Solution solution = new UniquePathsIi().new Solution();
      System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 当上边有阻碍时，障碍物右边的种类为0
         * 当左边有阻碍时，障碍物下边的种类为0
         * 当i格子上边或左边是障碍物时，不计算障碍物的格子
         * f(i) = f(i-1,j) + f(i, j-1) (i-1,j)、（i, j-1） != 阻碍物
         */
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //初始化dp
        boolean leftBlock = false, upBlock = false;
        for (int i=0; i<obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                leftBlock = true;
            }
            if (leftBlock) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j=0; j<obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                upBlock = true;
            }
            if (upBlock) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }
        //确定障碍物
        for (int j=1; j<obstacleGrid[0].length; j++) {
            for (int i=1; i<obstacleGrid.length; i++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}