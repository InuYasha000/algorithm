package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 14:06
 * @Description:移除元素
 */
public class Subject27 {
    public static void main(String[] args) {
        int nums[] = new int[]{3,2,2,3};
        removeElement(nums,3);
    }
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
