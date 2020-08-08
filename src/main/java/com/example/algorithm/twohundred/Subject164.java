package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/8/7 20:34
 * @Description: 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 */
public class Subject164 {
     public int maximumGap(int[] nums) {
         if(nums==null||nums.length<2){
             return 0;
         }
         Arrays.sort(nums);
         int max = nums[1]-nums[0];
         for(int i=1;i<nums.length;i++){
             if(max<Math.abs(nums[i]-nums[i-1])){
                 max = Math.abs(nums[i]-nums[i-1]);
             }
         }
         return max;
     }
    public int maximumGap1(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        int length = nums.length;
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        if(max == min){
            return 0;
        }
        int interval = (int)Math.ceil((max-min)*1.0/(length-1));
        int bucketCount = (max-min)/interval + 1;
        List<Integer>[] bucketArr = new ArrayList[bucketCount];
        int index = 0;
        for(int i=0;i<length;i++){
            index = (nums[i]-min)/interval;
            if(bucketArr[index]==null){
                bucketArr[index] = new ArrayList<>();
            }
            bucketArr[index].add(nums[i]);
        }
        int lastMax = Integer.MIN_VALUE;
        int res = 0;
        for(int j:bucketArr[0]){
            lastMax = Math.max(lastMax,j);
        }
        for(int i=1;i<bucketCount;i++){
            if(bucketArr[i]==null){
                continue;
            }
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;
            for(int j:bucketArr[i]){
                currentMin = Math.min(currentMin,j);
                currentMax = Math.max(currentMax,j);
            }
            res = Math.max(res,currentMin-lastMax);
            lastMax = currentMax;
        }
        return res;
    }
}
