package com.practice.leetcode.editor.cn;
  
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 547 👎 0

public class RotateList{
  public static void main(String[] args) {
       Solution solution = new RotateList().new Solution();
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode hh = head;
        int j = 1;
        while (hh.next != null) {
            hh = hh.next;
            j++;
        }
        k = k%j;
        if (k == 0) {
            return head;
        }
        int n = j - k;
        hh.next = head;
        while (n-- > 0) {
            hh = hh.next;
        }
        ListNode h = hh.next;
        hh.next = null;
        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}