package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 20:30
 * @Description:搜索插入位置
 */
public class Subject35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        while (left < nums.length && nums[left] < target) {
            left++;
        }
        return left;
    }
}
