package com.practice.leetcode.editor.cn;
  
//给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。 
//
// 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。 
//
// 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 
//。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,2,6], k = 2
//输出：[2,6]
//解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,4,3,3,5,4,9,6], k = 4
//输出：[2,3,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 1 <= k <= nums.length 
// 
// Related Topics 栈 堆 贪心算法 队列

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindTheMostCompetitiveSubsequence{
  public static void main(String[] args) {
       Solution solution = new FindTheMostCompetitiveSubsequence().new Solution();
      System.out.println(Arrays.toString(solution.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4)));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] re = new int[k];
        PriorityQueue<int[]> pQ =
                new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int size = k;
        int posi = nums.length - size;
        for (int j=0; j<=posi; j++) {
            pQ.offer(new int[]{nums[j], j});
        }
        int left = 0;
        for (int i=0; i<k; i++) {
            int[] reArr = pQ.poll();
            re[i] = reArr[0];
            left = reArr[1];
            while (pQ.peek() != null && pQ.peek()[1] < left) {
                pQ.poll();
            }
            posi++;
            if (posi < nums.length) {
                pQ.offer(new int[]{nums[posi], posi});
            }
        }
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}