package com.practice.leetcode.editor.cn;
  
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses{
  public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
       solution.generateParenthesis(3);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    int num = 0;
    int n = 0;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.num = 2*n;
        Character[]  arr = new Character[]{'(', ')'};
        List<Character> track = new ArrayList<>();
        backtrack(0, arr, track);
        return res;
    }

    private void backtrack(int index, Character[] arr, List<Character> track) {
           if (index == num) {
            if (!valid(track)) {
                return ;
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : track) {
                sb.append(c);
            }
            if (sb.length() != 0) {
                res.add(sb.toString());
            }
            return;
        }
        for (Character c : arr) {
            track.add(c);
            backtrack(index+1, arr, track);
            track.remove(track.size()-1);
        }
    }

    private boolean valid(List<Character> track) {
        if (track.isEmpty()) {
            return true;
        }
        boolean flag = !(track.get(0).equals(')') || (track.size() > 1 && track.get(track.size()-1).equals('(')));
        if (flag) {
            Stack<Character> s = new Stack<>();
            for (Character c : track) {
                if (!s.isEmpty()) {
                    Character pair = s.peek();
                    if (c.equals(')') && pair.equals('(')) {
                        s.pop();
                    } else {
                        s.push(c);
                    }
                } else {
                    s.push(c);
                }
            }
            if (s.isEmpty()) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}