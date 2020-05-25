package com.example.algorithm;

/**
 * @Description:缺失的第一个正数
 * @Date:2020/5/25
 * @Author: Cheng
 */
public class Subject41 {
    public int firstMissingPositive(int[] nums) {
        //判断交换回来的数字
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                //第 nums[i] 个位置的下标是 nums[i] - 1
                swap(nums, i, nums[i] - 1);
            }
        }
        //找出第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果之前的数都满足就返回 n + 1
        return nums.length + 1;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
