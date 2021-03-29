package com.practice.leetcode.editor.cn;
  
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1568 👎 0

public class ClimbingStairs{
  public static void main(String[] args) {
       Solution solution = new ClimbingStairs().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //f(4)
        //1+1+1+1
        //1+1+2
        //1+2+1
        //2+1+1
        //2+2
        //f(1)=1; f(2)=2; f(3)=3; f(4)=5 ... f(i)=f(i-1)+f(i-2);
        if (n < 3) {
            return n;
        }
        int pre = 2;
        int prePre = 1;
        int tmp = 0;
        for (int i=3; i<n; i++) {
            tmp = prePre;
            prePre = pre;
            pre = tmp + prePre;
        }
        return pre+prePre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}