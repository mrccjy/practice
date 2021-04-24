package com.practice.leetcode.editor.cn;
  
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 370 👎 0

import java.util.Stack;

public class AddTwoNumbersIi{
  public static void main(String[] args) {
       Solution solution = new AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //把长的栈作为循环主体
        if (stack1.size() < stack2.size()) {
            Stack<Integer> tmp = stack1;
            stack1 = stack2;
            stack2 = tmp;
        }

        ListNode head = null;
        ListNode curr = head;

        int extra = 0;
        while (!stack1.isEmpty()) {
            int val1 = stack1.pop();
            int val2 = 0;
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }
            int total = val1 + val2 + extra;
            if (total > 9) {
                extra = 1;
            } else {
                extra = 0;
            }
            total = total % 10;
            ListNode n = new ListNode(total);
            if (head == null) {
                head = n;
                curr = head;
            } else {
                curr.next = n;
                curr = curr.next;
            }
        }
        if (extra != 0) {
            curr.next = new ListNode(extra);
        }

        if (head == null || head.next == null) {
            return head;
        }

        //反转链表
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cu = prev.next;
        while (cu.next != null) {
            ListNode curNext = cu.next;
            cu.next = curNext.next;
            curNext.next = prev.next;
            prev.next = curNext;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}