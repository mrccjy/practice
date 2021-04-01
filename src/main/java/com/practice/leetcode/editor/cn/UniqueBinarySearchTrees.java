package com.practice.leetcode.editor.cn;
  
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

public class UniqueBinarySearchTrees{
  public static void main(String[] args) {
       Solution solution = new UniqueBinarySearchTrees().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] gn = new int[n+1];
        if (n < 1) {
            return 1;
        }
        gn[0] = gn[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                gn[i] += gn[j-1] * gn[i-j];
            }
        }
        return gn[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}