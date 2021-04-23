package com.practice.leetcode.editor.cn;
  
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针

public class PartitionList{
  public static void main(String[] args) {
       Solution solution = new PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        //输入：head = [1,4,3,2,5,2], x = 3
        //输出：[1,2,2,4,3,5]
        ListNode sentienl = new ListNode(0, head);
        ListNode dummy = sentienl;
        while (dummy.next != null && dummy.next.val < x) {
            dummy = dummy.next;
        }

        ListNode lessNumNode = dummy;
        while (lessNumNode != null && lessNumNode.next != null) {
            if(lessNumNode.next.val < x) {
                ListNode dummyNext = dummy.next;
                ListNode lessNode = lessNumNode.next;
                lessNumNode.next = lessNumNode.next.next;
                lessNode.next = null;
                dummy.next = lessNode;
                lessNode.next = dummyNext;
                dummy = dummy.next;
            } else {
                lessNumNode = lessNumNode.next;
            }
        }
        return sentienl.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}