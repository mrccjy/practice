package com.practice.leetcode.editor.cn;
  
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// 👍 565 👎 0

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList{
  public static void main(String[] args) {
       Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
        Map<Integer, Integer> map = new HashMap<>();
        if (head == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode pre = head;
        map.put(head.val, head.val);
        while (curr != null) {
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, curr.val);
                pre = curr;
                curr = curr.next;
                continue;
            }
            ListNode tmp = curr;
            pre.next = curr.next;
            curr = curr.next;
            tmp.next = null;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}