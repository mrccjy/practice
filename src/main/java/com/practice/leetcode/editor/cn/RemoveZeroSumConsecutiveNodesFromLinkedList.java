package com.practice.leetcode.editor.cn;
  
//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
// Related Topics 链表

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList{
  public static void main(String[] args) {
       Solution solution = new RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        //定义Map.遍历链表，把当前值相加链表之前所有链表的和的总和作为key,结点作为value
        //当多次出现同一个可以值时后面的Node会覆盖前面的Node,出现多个相同值意味着中间系列结点和为0
        //遍历结点，把和为0的节点删去
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }

        sum = 0;
        curr = dummy;
        while (curr != null) {
            sum += curr.val;
            curr.next = map.get(sum).next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}