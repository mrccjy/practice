package com.practice.leetcode.editor.cn;
  
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//        abcadcaa
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
      LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
       Solution solution = l.new Solution();
//       String s = "abcabcdd";
//       String s = "abcabcbb";
       String s = "abcadcaa";
      System.out.println(solution.lengthOfLongestSubstring(s));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return method1(s);
    }

      /**
       * 滑动窗口解法
       * @param s
       * @return
       */
    public int method2(String s) {
        Set<Character> existWords = new HashSet<>();
        int maxNotduplicSequenceSizeSofar = 0;
        int r = 0;
        for (int i=0; i<s.length();) {
            while (r < s.length() && !existWords.contains(s.charAt(r))) {
                existWords.add(s.charAt(r));
                r++;
            }
            maxNotduplicSequenceSizeSofar = Math.max(existWords.size(), maxNotduplicSequenceSizeSofar);
            if (r >= s.length()) {
                break;
            } else {
                while(i < r && existWords.contains(s.charAt(r))) {
                    existWords.remove(s.charAt(i++));
                }
            }
        }
        return maxNotduplicSequenceSizeSofar;
    }

      /**
       * 循环解法
       * @param s
       * @return
       */
    public int method1(String s) {
        HashMap<Character, Integer> existWords = new HashMap<>();
        int maxNotduplicSequenceSize = 0;
        int maxNotduplicSequenceSizeSofar = 0;
        for (int i=0; i<s.length(); i++) {
            if (!existWords.containsKey(s.charAt(i))) {
                maxNotduplicSequenceSize++;
                //设置没一个元素的下标
                existWords.put(s.charAt(i), i);
                //计算屡次最大不重复数
                maxNotduplicSequenceSizeSofar = Math.max(maxNotduplicSequenceSize, maxNotduplicSequenceSizeSofar);
            } else {
                //获取上一次重复的值的下标，循环从该处开始
                i = existWords.get(s.charAt(i));
                //清楚缓存
                existWords.clear();
                //重置该次不重复循环的次数
                maxNotduplicSequenceSize = 0;
            }
        }
        return maxNotduplicSequenceSizeSofar;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}