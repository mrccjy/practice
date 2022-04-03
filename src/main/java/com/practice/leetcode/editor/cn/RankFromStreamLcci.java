package com.practice.leetcode.editor.cn;
  
//假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说： 
//
// 实现 track(int x) 方法，每读入一个数字都会调用该方法； 
//
// 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。 
//
// 注意：本题相对原题稍作改动 
//
// 示例: 
//
// 输入:
//["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
//[[], [1], [0], [0]]
//输出:
//[null,0,null,1]
// 
//
// 提示： 
//
// 
// x <= 50000 
// track 和 getRankOfNumber 方法的调用次数均不超过 2000 次 
// 
// Related Topics 设计 树状数组 二分查找 数据流 
// 👍 29 👎 0

public class RankFromStreamLcci{
  public static void main(String[] args) {
       Solution solution = new RankFromStreamLcci().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class StreamRank {
      List<Integer> list;
      public StreamRank() {
          list = new ArrayList();
      }

      public void track(int x) {
          int index = getRankOfNumber(x);
          list.add(index, x);
      }

      public int getRankOfNumber(int x) {
          int size = list.size();
          int n = size;
          if (n == 0) {
              return 0;
          }
          int l = 0;
          int mid = 0;
          while (l <= n) {
              mid = l+((n-l)>>1);
              if (mid == size) {
                  return l;
              }
              int num = list.get(mid);
              if (num == x) {
                  l = mid+1;
              } else if (num < x){
                  l = mid+1;
              } else {
                  n = mid-1;
              }
          }
          return l;
      }
}

/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */
//leetcode submit region end(Prohibit modification and deletion)

}