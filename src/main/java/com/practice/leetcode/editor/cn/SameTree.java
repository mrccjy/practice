package com.practice.leetcode.editor.cn;
  
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree{
  public static void main(String[] args) {
       Solution solution = new SameTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        Deque<TreeNode> queP = new ArrayDeque<>();
        Deque<TreeNode> queQ = new ArrayDeque<>();
        queP.offer(p);
        queQ.offer(q);

        while (!queP.isEmpty() && !queQ.isEmpty()) {
            TreeNode nP = queP.poll();
            TreeNode nQ = queQ.poll();
            if (nP.val != nQ.val) {
                return false;
            }
            if (nP.left != null && nQ.left != null) {
                queP.offer(nP.left);
                queQ.offer(nQ.left);
            } else if (nP.left == null && nQ.left == null) {

            } else {
                return false;
            }
            if (nP.right != null && nQ.right != null) {
                queP.offer(nP.right);
                queQ.offer(nQ.right);
            } else if (nP.right == null && nQ.right == null) {

            } else {
                return false;
            }
        }
        return queP.size() == queQ.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}