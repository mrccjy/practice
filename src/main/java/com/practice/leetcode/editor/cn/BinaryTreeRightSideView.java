package com.practice.leetcode.editor.cn;
  
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列

import java.util.*;

public class BinaryTreeRightSideView{
  public static void main(String[] args) {
       Solution solution = new BinaryTreeRightSideView().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> valMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> depthQueue = new LinkedList();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        depthQueue.offer(0);
        int maxDepth = 0;
        while(queue.peek() != null) {
            TreeNode n = queue.poll();
            int depth = depthQueue.poll();

            maxDepth = Math.max(maxDepth, depth);
            valMap.put(depth, n.val);
            if (n.left != null) {
                queue.add(n.left);
                depthQueue.add(depth+1);
            }
            if (n.right != null) {
                queue.add(n.right);
                depthQueue.add(depth+1);
            }
        }
        for (int i=0; i<=maxDepth; i++) {
            list.add(valMap.get(i));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}