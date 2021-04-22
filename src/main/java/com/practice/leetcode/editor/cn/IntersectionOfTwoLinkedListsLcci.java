package com.practice.leetcode.editor.cn;
  
//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个
//节点是同一节点（引用完全相同），则这两个链表相交。 示例 1： 输入：intersectVal = 8, listA = [4,1,8,4,5], listB 
//= [5,0,1,8,4,5], skipA = 2, skipB = 3 输出：Reference of the node with value = 8 输入
//解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4
//,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。 示例 2： 输入：intersectVal = 2, listA = [0
//,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with v
//alue = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
// [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。 示例 3： 输入：intersectVal = 0, listA
// = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [
//2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。 解释：
//这两个链表不相交，因此返回 null。 注意： 如果两个链表没有交点，返回 null 。 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循
//环。 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 Related Topics 链表

public class IntersectionOfTwoLinkedListsLcci{
  public static void main(String[] args) {
       Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    /**
     * 双指针法，a指针与b指针每一步同时向后走，当走到链尾还未相交时把自己的指针指向对方链头继续遍历，结束遍历后若有相交可得出相交节点
     * a+b = b+a，a指针与b指针走过的路程长度是一样的
     * 当有相交时，会在相交节点相遇而结束遍历
     * 当没有相交时，因路程长度一致，所以最后会在连表末尾的null值处相遇从而结束遍历
     * 例如:
     * a:1->2->3->4->5->6
     * b:7->8->5->6
     * 等同于：
     * a+b = 1->2->3->4->5->6->7->8->5->6
     * b+a = 7->8->5->6->1->2->3->4->5->6
     * a1、b1指针同时链头处遍历最终会在5处相遇而结束。
     *
     * a:1->2->3
     * b:7->8->5
     * 等同于：
     * a+b = 1->2->3->7->8->5
     * b+a = 7->8->5->1->2->3
     * a1、b1指针同时链头处遍历最终会在链尾null处相遇而结束。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
            if (a == b) {
                return a;
            }
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}