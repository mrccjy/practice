package com.practice.leetcode.editor.cn;
  
//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。 
//
// 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.
//val，那么就有 j > i 且 node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0
// 。 
//
// 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。 
//
// 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 示例 3： 
//
// 输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 对于链表中的每个节点，1 <= node.val <= 10^9 
// 给定列表的长度在 [0, 10000] 范围内 
// 
// Related Topics 栈 链表 
// 👍 150 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList{
  public static void main(String[] args) {
       Solution solution = new NextGreaterNodeInLinkedList().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    /**
     *
     * 把链表转换为数组，链表头到链表尾为数组0-n，定义res数组为链表下一个更大结点数组
     * 单调栈存储链表数组元素下标值，从栈顶到栈底存储值从小到大，但是从栈顶到栈底的值对应的数组结点元素值是递增的
     * 遍历链表数组，当栈为空时把元素下标入栈，当栈不为空时取出栈对应的下标值判断该下标处的数组值是否小于当前链表数组值，
     * 小于则把res对应该栈值（下标）定义为当前链表结点值，
     * 当栈为空或者链表结点值大于等于栈下标对应元素值时结束
     *
     */
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head;
        List<Integer> list = new ArrayList();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        int[] res = new int[nums.length];

        Stack<Integer> s = new Stack<>();
        for (int i=0; i<nums.length; i++) {
            //栈中的元素一定是在当前结点之前的
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                res[s.pop()] = nums[i];
            }
            s.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}