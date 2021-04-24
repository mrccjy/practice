package com.practice.leetcode.editor.cn;
  
//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 18 👎 0

public class SwappingNodesInALinkedList{
  public static void main(String[] args) {
       Solution solution = new SwappingNodesInALinkedList().new Solution();
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = dummy;
        ListNode leftPrev = dummy;
        ListNode rightPrev = dummy;
        for (int i=0; i<length; i++) {
            if (i == Math.min(k-1,(length-k))) {
                leftPrev = curr;
            }
            //n-k+1为右边位置,下标为n-k
            if (i == Math.max(k-1,(length-k))) {
                rightPrev = curr;
            }
            curr = curr.next;
        }
        if (leftPrev == rightPrev) {
            return head;
        }
        if (leftPrev.next == rightPrev) {
            ListNode tmp = rightPrev.next;
            rightPrev.next = tmp.next;
            tmp.next = rightPrev;
            leftPrev.next = tmp;
        } else {
            ListNode tmpLeft = leftPrev.next;
            ListNode tmpRight = rightPrev.next;

            leftPrev.next = leftPrev.next.next;
            rightPrev.next = rightPrev.next.next;

            tmpRight.next = leftPrev.next;
            tmpLeft.next = rightPrev.next;

            leftPrev.next = tmpRight;
            rightPrev.next = tmpLeft;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}