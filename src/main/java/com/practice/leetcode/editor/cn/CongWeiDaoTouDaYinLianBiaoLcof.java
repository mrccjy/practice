package com.practice.leetcode.editor.cn;
  
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
  public static void main(String[] args) {
       Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack();
        ListNode curr = head;
        while (curr != null) {
            s.push(curr.val);
            curr = curr.next;
        }
        int[] a = new int[s.size()];
        int i=0;
        while (!s.isEmpty()) {
            a[i++] = s.pop();
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}