package com.practice.leetcode.editor.cn;
  
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表

public class ReverseLinkedListIi{
  public static void main(String[] args) {
       Solution solution = new ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = right - left;
        ListNode sent = new ListNode(0, head);
        ListNode pre = sent;

        ListNode curr = head;
        while (curr != null && (--left)>0) {
            pre = curr;
            curr = curr.next;
        }
        // sentinel   ->   1   ->   2   ->   3   ->   4
        //  pre           curr
        ListNode tmp = null;
        while (curr != null && (count--) > 0) {
            //                      tmp
            //sentinel   ->   1  ->   2   ->   3   ->   4
            //  pre          curr
            tmp = curr.next;

            //                       tmp
            //                        2-------┐
            //                                |
            //                                ∨
            //sentinel   ->   1      -->      3   ->   4
            //  pre          curr
            //
            curr.next = tmp.next;

            //               tmp
            //                2
            //                |
            //                ∨
            //sentinel   ->   1   -->   3   ->   4
            //  pre         curr
            //
            tmp.next = pre.next;


            //               tmp
            //sentinel   -->  2   -->   1   -->   3   ->   4
            //  pre                    curr
            //curr一直跟着1这个固定节点，因为1每次都链接新的后续节点，所以不需要变动curr就可以完成迭代移动
            pre.next = tmp;
        }
        return sent.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}