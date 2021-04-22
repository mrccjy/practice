package com.practice.leetcode.editor.cn;
  
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 
// 
// Related Topics 链表 
// 👍 578 👎 0

public class RemoveLinkedListElements{
  public static void main(String[] args) {
      RemoveLinkedListElements t = new RemoveLinkedListElements();
       Solution solution = t.new Solution();
       ListNode n1 = t.new ListNode(1);
       ListNode n2 = t.new ListNode(2);
       ListNode n3 = t.new ListNode(6);
       ListNode n4 = t.new ListNode(3);
       ListNode n5 = t.new ListNode(4);
       ListNode n6 = t.new ListNode(5);
       ListNode n7 = t.new ListNode(6);
       n1.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = n5;
       n5.next = n6;
       n6.next = n7;
       solution.removeElements(n1, 6);
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
    public ListNode removeElements(ListNode head, int val) {

        ListNode prev = head;
        if (head == null) {
            return null;
        }
        ListNode curr = head.next;
        ListNode tmp = null;
        while (curr != null) {
            if (curr.val == val) {
                tmp = curr;
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
            if (tmp != null) {
                tmp.next = null;
            }
        }
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}