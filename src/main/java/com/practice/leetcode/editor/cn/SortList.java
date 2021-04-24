package com.practice.leetcode.editor.cn;
  
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1104 👎 0

public class SortList{
  public static void main(String[] args) {
       SortList s = new SortList();
       Solution solution = s.new Solution();
       ListNode h4 = s.new ListNode(3);
       ListNode h3 = s.new ListNode(1, h4);
       ListNode h2 = s.new ListNode(2, h3);
       ListNode head = s.new ListNode(4, h2);
       solution.sortList(head);
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
    public ListNode sortList(ListNode head) {
//        return recursiveSort(head, null);
        return bottomToUpSort(head);
    }

    /**
     *
     * 自底向上排序
     * 空间复杂度O(1)、时间复杂度O(n*logn)
     *
     * 链表：4 - 2 - 3 - 1
     * 第一趟：两两链表长度为1
     *      第一次：2 - 4 - 3 - 1
     *      第二次：2 - 4 - 1 - 3
     * 第二趟：两两链表长度为2
     *      第一次：1 - 2 - 3 - 4
     *      完成
     * @param head
     */
    private ListNode bottomToUpSort(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode curr = sentinel.next;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        for (int subLength = 1; subLength < length; subLength = subLength * 2) {
            ListNode pre = sentinel;
            curr = sentinel.next;
            while (curr != null) {
                ListNode l1 = curr;
                for (int i=1; i<subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode l2 = curr.next;
                curr.next = null;
                curr = l2;
                for (int i=1; i<subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode sorted = merge(l1, l2);
                pre.next = sorted;
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }

        return sentinel.next;
    }

        /**
         *
         * 自顶向下使用递归完成排序
         * 空间复杂度O(logn)、时间复杂度O(n*logn)
         *
         * @param head
         * @param tail
         * @return
         */
    private ListNode recursiveSort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        //此处会在head.next == tail除去掉tail结点，也就是mid结点是不参与计算的，
        ListNode first = recursiveSort(head, mid);
        ListNode second = recursiveSort(mid, tail);
        ListNode sortedList = merge(first, second);
        return sortedList;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sent = new ListNode(0);
        ListNode curr = sent;
        ListNode l = l1;
        ListNode r = l2;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if (l != null) {
            curr.next = l;
        }
        if (r != null) {
            curr.next = r;
        }
        return sent.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}