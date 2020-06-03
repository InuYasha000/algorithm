package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/27 22:42
 * @Description:最大子序和
 */
public class Subject53 {
    public int maxSubArray(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (arr[i - 1] < 0) {
                arr[i] = nums[i];
            } else {
                arr[i] = arr[i - 1] + nums[i];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
