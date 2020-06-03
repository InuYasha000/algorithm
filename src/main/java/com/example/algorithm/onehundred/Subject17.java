package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:电话号码的字母组合
 * @Date:2020/5/22
 * @Author: Cheng
 */
public class Subject17 {
        List<List<Integer>> result = new ArrayList<>();
        int firstindex = 0,secondindex=0;
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(nums.length<3){
                return result;
            }
            Arrays.sort(nums);
            for(int i=0;i<nums.length-3;i++){//-3
                firstindex = i;
                if(i==0||(i>0&&nums[i]!=nums[i-1])){//i==0保证一定有一个进入循环，这里不用判断i+1超出，下面同理，用i-1去重比i+1好，因为有个误区，你应该和前面已经计算的比较，而不是后面还没计算的比较
                    threesums(i,nums,target);
                }
            }
            return result;
        }
        public void threesums(int index,int nums[],int target){
            for(int i=index+1;i<nums.length-2;i++){//-2
                if(i==index+1||nums[i]!=nums[i-1]){
                    secondindex = i;
                    twosums(i,nums,target);
                }
            }
        }
        public void twosums(int index,int nums[],int target){
            int left = index+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[firstindex]+nums[secondindex]+nums[left]+nums[right]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[firstindex]);
                    list.add(nums[secondindex]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(nums[firstindex]+nums[secondindex]+nums[left]+nums[right]>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
}
