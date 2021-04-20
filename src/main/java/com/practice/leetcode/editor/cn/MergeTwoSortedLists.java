package com.practice.leetcode.editor.cn;
  
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1674 👎 0

public class MergeTwoSortedLists{
  public static void main(String[] args) {
       Solution solution = new MergeTwoSortedLists().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode leftNode = l1;
        ListNode rightNode = l2;
        while (leftNode != null && rightNode != null) {
            if (head == null) {
                head = new ListNode();
                curr = head;
            } else {
                curr.next = new ListNode();
                curr = curr.next;
            }
            if (leftNode.val <= rightNode.val) {
                curr.val = leftNode.val;
                leftNode = leftNode.next;
            } else {
                curr.val = rightNode.val;
                rightNode = rightNode.next;
            }
        }
        while (leftNode != null) {
            if (head == null) {
                head = new ListNode();
                curr = head;
            } else {
                curr.next = new ListNode();
                curr = curr.next;
            }
            curr.val = leftNode.val;
            leftNode = leftNode.next;
        }
        while (rightNode != null) {
            if (head == null) {
                head = new ListNode();
                curr = head;
            } else {
                curr.next = new ListNode();
                curr = curr.next;
            }
            curr.val = rightNode.val;
            rightNode = rightNode.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}