package com.practice.leetcode.editor.cn;
  
//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。 
//
// 
//
// 示例 1： 
//
// 
//输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] 由小写英文字母组成。 
// k 的取值范围是 [1, 不同 words[i] 的数量] 
// 
//
// 
//
// 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列）

import java.util.*;

public class TopKFrequentWords{
  public static void main(String[] args) {
       Solution solution = new TopKFrequentWords().new Solution();
       solution.topKFrequent(new String[]{"i","love"}, 4);
//      System.out.println("is".compareTo("sunny"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Obj> map = new HashMap<>();
        for (String word : words) {
            map.compute(word, (s, obj) -> {
                if (obj == null) {
                    Obj o = new Obj();
                    o.str = s;
                    o.frequents = 1;
                    return o;
                } else {
                    obj.frequents += 1;
                }
                return obj;
            });
        }
        PriorityQueue<Obj> queue = new PriorityQueue<Obj>((o1, o2) -> {
            return o1.frequents == o2.frequents ? o1.str.compareTo(o2.str) : o2.frequents - o1.frequents;
        });
        for (Obj value : map.values()) {
            queue.offer(value);
        }
        int i=0;
        List<String> list = new ArrayList<>();
        while (i<k && !queue.isEmpty()) {
            i++;
            list.add(queue.poll().str);
        }
        return list;
    }
}
class Obj {
      String str;
      int frequents;
}
//leetcode submit region end(Prohibit modification and deletion)

}