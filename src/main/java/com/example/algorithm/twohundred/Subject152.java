package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/5 22:21
 * @Description:乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class Subject152 {
    public static void main(String[] args) {
        maxProduct(new int[]{-2,0,-1});
    }
    public static int maxProduct(int[] nums) {
        int a = 1,max = nums[0];
        for(int i:nums){
            a = a*i;
            if(max<a){
                max = a;
            }
            if(i==0){
                a =1;
            }
        }
        a=1;
        for(int i=nums.length-1;i>=0;i--){
            a = a*nums[i];
            if(max<a){
                max = a;
            }
            if(nums[i]==0){
                a =1;
            }
        }
        return max;
    }
}
