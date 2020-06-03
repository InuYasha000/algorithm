package com.example.algorithm.onehundred;

import java.util.Arrays;

/**
 * @Description:最接近的三数之和
 * @Date:2020/5/22
 * @Author: Cheng
 */
public class Subject16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        // int result[] = new int[3];
        int sub = Integer.MAX_VALUE;//这里需要设置很大的值，不然太小有可能一直找不到比这个数更小的
        int left = 0, right = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (Math.abs(nums[i] + nums[left] + nums[right] - target) - sub < 0) {
                    sub = Math.abs(nums[i] + nums[left] + nums[right] - target);
                    sum = nums[i] + nums[left] + nums[right];
                }
                if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sum;

    }
}
