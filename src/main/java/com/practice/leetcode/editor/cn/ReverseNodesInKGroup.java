package com.practice.leetcode.editor.cn;
  
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 
// 👍 1577 👎 0

public class ReverseNodesInKGroup{
  public static void main(String[] args) {
       Solution solution = new ReverseNodesInKGroup().new Solution();
       ListNode l5 = new ListNode(5);
       ListNode l4 = new ListNode(4, l5);
       ListNode l3 = new ListNode(3, l4);
       ListNode l2 = new ListNode(2, l3);
       ListNode head = new ListNode(1, l2);
       solution.reverseKGroup(head, 2);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
 /*  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k ==1) {
            return head;
        }
        ListNode curr = head.next;
        int sum = 1, i = 0;
        while (curr != null) {
            sum++;
            curr = curr.next;
        }
        int times = sum/k;
        ListNode headDummy = new ListNode(-1, head);
        ListNode moveDummy = headDummy;
        ListNode prev = head;
        curr = head.next;
        ListNode tmp = null;
        int j = 1;
        while (curr != null && i < times) {
            tmp = curr.next;
            prev.next = curr.next;
            curr.next = moveDummy.next;
            moveDummy.next = curr;
            curr = tmp;
            j++;
            if (j == k) {
                j = 1;
                i++;
                moveDummy = prev;
                prev = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (i >= times) {
                break;
            }
        }
        return headDummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}