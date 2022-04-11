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
        //先进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //和上一个数字相同的数字跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length -1;
            int value = 0 - nums[i];
            int twoSum = 0;
            //确定了第一个数之后，剩余的两个数通过左侧和右侧数双指针方式确定，左侧往右侧移动，右侧往左侧移动，
            while (l < r) {

                twoSum = nums[l] + nums[r];
                if (twoSum > value) {
                    //当左+右小于目标数时，左侧向右边移动
                    r--;
                } else if (twoSum < value) {
                    //当左+右大于目标数时，右侧向左侧移动
                    l++;
                } else {
                    //当相等时，判断左侧+1的数跟当前左侧数是否一致，一致则左侧指针向前一步防重
                    while ((l+1) < nums.length && nums[l+1] == nums[l]) {
                        l++;
                    }
                    //当相等时，同时也判断右侧-1的数跟当前右侧数是否一致，一致则右侧指针-1防重
                    while ((r-1) > l && nums[r-1] == nums[r]) {
                        r--;
                    }
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    //记录好值之后，左侧指针向前移动一步继续匹配
                    l++;
                    lists.add(li);

                }
            }
        }
        return lists;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}