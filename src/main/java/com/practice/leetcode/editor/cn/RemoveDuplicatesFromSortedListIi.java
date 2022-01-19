package com.practice.leetcode.editor.cn;
  
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 606 👎 0

public class RemoveDuplicatesFromSortedListIi{
  public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        /*ListNode sent = new ListNode(0,head);
        ListNode prev = sent;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            boolean skip = false;
            boolean isHead = true;
            if (head != curr) {
                isHead = false;
            }
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                prev.next = curr.next;
                skip = true;
            }
            if (!skip) {
                if (isHead) {
                    sent.next = curr;
                }
                prev = curr;
            }
            curr = curr.next;
        }
        return sent.next;*/

        //另一简单实现
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0, head);
        ListNode curr = sentinel;
        while (curr != null && curr.next != null && curr.next.next != null) {

            if (curr.next.val == curr.next.next.val) {
                int i = curr.next.val;
                ListNode innCurr = curr.next.next.next;
                while (innCurr != null && innCurr.val == i) {
                    innCurr = innCurr.next;
                }
                curr.next = innCurr;

            } else {
                curr = curr.next;
            }
        }
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}