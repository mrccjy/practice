package com.practice.leetcode.editor.cn;
  
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 571 👎 0

public class ReorderList{
  public static void main(String[] args) {
       Solution solution = new ReorderList().new Solution();
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //通过快慢指针确定中心节点
        // a -> b -> c -> d    a -> b -> c -> d -> e
        //     中点                      中点
        ListNode sent = new ListNode(0, head);
        ListNode slow = sent;
        ListNode fast = sent;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 把中点往后断开形成两个链表
        // a -> b   c -> d
        // a -> b -> c    d -> e
        ListNode firstList = head;
        ListNode secondList = null;
        if (fast.next == null) {
            secondList = slow.next;
            slow.next = null;
        } else {
            secondList = slow.next.next;
            slow.next.next = null;
        }


        //再把后面的链表反转
        // d -> c        e->d
        ListNode reSent = new ListNode(0, secondList);
        ListNode curr = secondList;
        ListNode next = null;
        while (curr.next != null) {
            next = curr.next;
            curr.next = curr.next.next;
            next.next = reSent.next;
            reSent.next = next;
        }
        ListNode reverScondList = reSent.next;

        //再把前面链表与反转后的链表每次有序地从第一、第二个链表中取出结点链接起来

        //看起来像这样子，第一个链表总比第二个链表多一个，所以无需处理最后一个结点，循环就处理完了
        // 1->2->3
        // | /|/ \
        // 4->5-> 6
        //  1 -> 4 -> 2 -> 5 -> 3 -> 6
        //或者
        // 1->2->3
        // | /|/
        // 4->5
        //  1 -> 4 -> 2 -> 5 -> 3
        while (firstList != null && reverScondList != null) {
            ListNode firstNext = firstList.next;
            ListNode secondNext = reverScondList.next;

            firstList.next = reverScondList;
            firstList = firstNext;

            reverScondList.next = firstList;
            reverScondList = secondNext;

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}