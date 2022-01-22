package com.practice.leetcode.editor.cn;
  
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵

public class NumberOfIslands{
  public static void main(String[] args) {
       Solution solution = new NumberOfIslands().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j< grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    floodFill(i, j, grid);
                }
            }
        }
        return res;
    }

      private void floodFill(int i, int j, char[][] grid) {
          if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
              //越界
              return;
          }
          if (grid[i][j] == '0') {
              //遇到海水终止
              return;
          }
          //将i,j处变为海水，等同于用visit[][]函数记录已经访问过了
          grid[i][j] = '0';
          //向上下左右填满海水
          floodFill(i-1, j, grid);
          floodFill(i+1, j, grid);
          floodFill(i, j-1, grid);
          floodFill(i, j+1, grid);
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}