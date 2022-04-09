package com.practice.leetcode.editor.cn;
  
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4614 👎 0

import java.util.*;

public class ThreeSum{
  public static void main(String[] args) {
       Solution solution = new ThreeSum().new Solution();
       int[] n = new int[]{-1,0, 1, 2, -1, -4};
       solution.threeSum(n);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<String> exists = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length -1;
            int value = 0 - nums[i];
            int twoSum = 0;
            while (l < r) {
                twoSum = nums[l] + nums[r];
                if (twoSum > value) {
                    r--;
                } else if (twoSum < value) {
                    l++;
                } else {

                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    Collections.sort(li);
                    l++;
                    String e = li.get(0).toString() + li.get(1).toString() + li.get(2).toString();
                    if (exists.contains(e)) {
                        continue;
                    }
                    exists.add(e);
                    lists.add(li);

                }
            }
        }
        return lists;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}