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
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
      LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
       Solution solution = l.new Solution();
       String s = "abcabcdd";
//       String s = "abcabcbb";
//       String s = "abcadcaa";
//       String s = "pwwkew";
//       String s = "bbtablud";
//       String s = "bpfbhmipx";
      System.out.println(solution.lengthOfLongestSubstring(s));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return method4(s);
    }

      /**
       * 网上解法
       * @param s
       * @return
       */
    public int method3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;

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
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            if (!existWords.containsKey(s.charAt(i))) {
                maxNotduplicSequenceSize++;
                //设置没一个元素的下标
                existWords.put(s.charAt(i), i);
                //计算屡次最大不重复数
                maxNotduplicSequenceSizeSofar = Math.max(maxNotduplicSequenceSize, maxNotduplicSequenceSizeSofar);
            } else {
                //获取上一次重复的值的下标，循环从该处开始
                int tmp = i;
                i = existWords.get(s.charAt(i));
                //清楚缓存
                for (int j=start; j<=i; j++) {
                    existWords.remove(s.charAt(j));
                    maxNotduplicSequenceSize--;
                }
                start = i + 1;
                i = tmp;
                existWords.put(s.charAt(i), i);
                maxNotduplicSequenceSize = existWords.size();
            }
        }
        return maxNotduplicSequenceSizeSofar;
    }

      /**
       * 滑动窗口
       * @param s
       * @return
       */
    public int method4(String s) {
        //表示每个字符出现的次数
        int[] ch = new int[128];
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            ch[c]++;

            //出现重复时，左侧窗口向前缩小
            while (ch[c] > 1) {
                //窗口每向前一步，代表对应字符数字少了1个
                char le = s.charAt(left);
                ch[le]--;
                left++;
            }
            //去除了重复字符之后，查看当前无重复字串大小与先前记录的最大大小哪个大，取较大值
            maxLength = Math.max(right - left + 1, maxLength);

            //向右扩大窗口
            right++;
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}