package com.practice.leetcode.editor.cn;
  
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryWatch{
  public static void main(String[] args) {
       Solution solution = new BinaryWatch().new Solution();
      System.out.println(solution.readBinaryWatch(9).toString());
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        if (turnedOn == 0) {
            ret.add("0:00");
            return ret;
        }
        int[] pw = new int[]{0,1,2,3,4,5,6,7,8,9};
        List<Integer> track = new ArrayList<>();
        backtrack(0, pw, track, turnedOn);


        for (List<Integer> l : res) {
            int hour = 0;
            int min = 0;
            for (Integer i : l) {
                if (i < 4) {
                    hour += Math.pow(2,i);
                } else {
                    min += Math.pow(2, i-4);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (min == 0) {
                sb.append("00");
            } else if (min < 10) {
                sb.append("0" + min);
            } else {
                sb.append(min);
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    private void backtrack(int index, int[] pw, List<Integer> track, int n) {
        if (track.size() == n) {
            if (!valid(track)) {
                return;
            }
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i=index; i<pw.length; i++) {
            Integer num = pw[i];
            if (!valid(track) || track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(i+1, pw, track, n);
            track.remove(num);
        }
    }

    private boolean valid(List<Integer> track) {
        return  !((track.contains(2) && track.contains(3))
                || (track.contains(6) && track.contains(7) && track.contains(8) && track.contains(9)));
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}