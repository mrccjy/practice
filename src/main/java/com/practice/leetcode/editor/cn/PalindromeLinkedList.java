package com.practice.leetcode.editor.cn;
  
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

import java.util.HashMap;
import java.util.Map;

public class PalindromeLinkedList{
  public static void main(String[] args) {
       Solution solution = new PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap();
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        map.put(++i, slow.val);
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            map.put(++i, slow.val);
        }
        if (fast.next == null) {
            i--;
        }
        ListNode right = slow.next;
        ListNode left = head;
        while (right != null) {
            if (right.val != map.get(i--)) {
                return false;
            }
            right = right.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}