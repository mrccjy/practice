package com.practice.leetcode.editor.cn;
  
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 857 👎 0

import java.util.ArrayList;
import java.util.List;

public class NQueens{
  public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
       solution.solveNQueens(4);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<List<String>> res = new ArrayList<>();
      int n = 0;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] nn = new char[n][n];
        for (int i=0; i< nn.length; i++) {
            for (int j=0; j<nn[i].length; j++) {
                nn[i][j] = '.';
            }
        }
        backtrack(0,0, nn);
        return res;
    }

    private void backtrack(int i, int num, char[][] nn) {
          if (num == n) {
              List<String> list = new ArrayList<>();
              for (char[] arr : nn) {
                  StringBuilder sb = new StringBuilder();
                  for (char c : arr) {
                      sb.append(c);
                  }
                  list.add(sb.toString());
              }
              res.add(list);
              return;
          }
          if (i == n) {
              return;
          }
          for(int s=i; s<n; s++) {
              for (int y=0; y<n; y++) {
                  if (!valid(s, y, nn)) {
                      continue;
                  }
                  nn[s][y] = 'Q';
                  backtrack(s+1, num+1, nn);
                  nn[s][y] = '.';
              }
          }
    }

    private boolean valid(int i, int j, char[][] nn) {
        //检查行
        for (int y=0; y<n; y++) {
            if (nn[i][y] == 'Q') {
                return false;
            }
        }

        //检查列
        for (int s=0; s<n; s++) {
            if (nn[s][j] == 'Q') {
                return false;
            }
        }
        //检查左上
        for (int s=i-1, y=j-1; s>=0 && y>=0; s--, y--) {
            if (nn[s][y] == 'Q') {
                return false;
            }
        }
        //检查右上
        for (int s=i-1, y=j+1; s>=0 && y<n; s--, y++) {
            if (nn[s][y] == 'Q') {
                return false;
            }
        }
        return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}