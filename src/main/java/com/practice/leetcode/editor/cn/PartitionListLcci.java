package com.practice.leetcode.editor.cn;
  
//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
// 
// Related Topics 链表 双指针 
// 👍 58 👎 0

public class PartitionListLcci{
  public static void main(String[] args) {
       Solution solution = new PartitionListLcci().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode partition(ListNode head, int x) {
        //解法一
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
        //解法二
       /* ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode less = pre;
        while (less.next != null) {
            if ( less.next.val < x) {
                ListNode target = less.next;
                less.next = less.next.next;
                target.next = pre.next;
                pre.next = target;
                pre = pre.next;
            } else {
                less = less.next;
            }
        }
        return dummy.next;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}