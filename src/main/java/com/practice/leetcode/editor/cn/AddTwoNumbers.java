package com.practice.leetcode.editor.cn;
  
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

public class AddTwoNumbers{
  public static void main(String[] args) {
      AddTwoNumbers a = new AddTwoNumbers();
       Solution solution = a.new Solution();
       ListNode l1 = a.new ListNode(9);
       ListNode l2 = a.new ListNode(9);
       ListNode l3 = a.new ListNode(9);
       l1.next = l2;
       l2.next = l3;
       ListNode r1 = a.new ListNode(9);
       ListNode r2 = a.new ListNode(9);
       r1.next = r2;
       ListNode result = solution.addTwoNumbers(l1, r1);
       while (result != null) {
           System.out.print(result.val);
           result = result.next;
       }

  }
  //leetcode submit region begin(Prohibit modification and deletion)

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = null;
        ListNode rLast = null;
        ListNode bit1 = l1;
        ListNode bit2 = l2;
        int carryNum = 0;
        int result = 0;
        ListNode next = null;
        while (bit1 != null || bit2 != null || carryNum != 0) {
            result = carryNum;
            if (bit1 != null) {
                result += bit1.val;
                bit1 = bit1.next;
            }
            if (bit2 != null) {
                result += bit2.val;
                bit2 = bit2.next;
            }
            if (result > 9) {
                carryNum = 1;
                result -= 10;
            } else {
                carryNum = 0;
            }
            next = new ListNode(result);
            if (r == null) {
                r = next;
                rLast = r;
            } else {
                rLast.next = next;
                rLast = next;
            }
            result = 0;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}