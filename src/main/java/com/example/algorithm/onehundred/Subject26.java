package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 14:01
 * @Description:删除排序数组中的重复项
 */
public class Subject26 {
    public int removeDuplicates(int[] nums) {//两个指针
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
