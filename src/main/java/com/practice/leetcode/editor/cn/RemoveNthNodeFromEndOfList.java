package com.practice.leetcode.editor.cn;
  
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针

public class RemoveNthNodeFromEndOfList{
  public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return null;
        }
        ListNode nth = head;
        for (int i=1; i<n; i++) {
            if(nth.next == null) {
                nth = null;
            }
            nth = nth.next;
        }
        if (nth == null) {
            return null;
        }
        ListNode prev = null;
        ListNode pprev = null;
        ListNode curr = head;
        while (nth != null) {
            pprev = prev;
            prev = curr;
            curr = curr.next;
            nth = nth.next;
        }
        ListNode h = head;
        if (pprev == null) {
            h = prev.next;
        } else {
            pprev.next = prev.next;
        }
        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}