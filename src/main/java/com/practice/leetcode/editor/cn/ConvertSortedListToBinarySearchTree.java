package com.practice.leetcode.editor.cn;
  
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表

public class ConvertSortedListToBinarySearchTree{
  public static void main(String[] args) {
       Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if ( head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode sent = new ListNode(0, head);
        ListNode slow = sent;
        ListNode fast = sent;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        ListNode rightNode = slow.next.next;
        slow.next = null;

        TreeNode h = new TreeNode(middle.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(rightNode);
        h.left = left;
        h.right = right;

        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}