package com.example.algorithm.threehundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/13 20:30
 * @Description:长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 */
public class Subject209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int len = 0;
        int start = 0,end = 0;
        for(;end<nums.length;end++){
            sum+=nums[end];
            while(sum>=s){
                len = len==0?end-start+1:Math.min(end-start+1,len);
                sum-=nums[start++];
            }
        }
        return len;
    }
}
