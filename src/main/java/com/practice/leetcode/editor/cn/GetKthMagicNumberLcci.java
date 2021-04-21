package com.practice.leetcode.editor.cn;
  
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学

import java.util.PriorityQueue;

public class GetKthMagicNumberLcci{
  public static void main(String[] args) {
       Solution solution = new GetKthMagicNumberLcci().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue = new PriorityQueue();
        queue.offer(1L);
        int i = 0;
        Long target = 0L;
        while (i<k) {
            target = queue.poll();
            if (!queue.contains(target * 3)) {
                queue.offer(target * 3);
            }
            if (!queue.contains(target * 5)) {
                queue.offer(target * 5);
            }
            if (!queue.contains(target * 7)) {
                queue.offer(target * 7);
            }
            i++;
        }
        return target.intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}