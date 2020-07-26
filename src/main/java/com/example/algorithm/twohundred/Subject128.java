package com.example.algorithm.twohundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cheng
 * @Date: 2020/7/26 11:28
 * @Description:最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Subject128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,String> hasHandler = new HashMap<>();
        Map<Integer,String> numsMap = new HashMap<>();
        Map<Integer,Integer> countMap = new HashMap<>();
        int max = 0;
        for(int i:nums){
            numsMap.put(i,"1");
        }
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            if(hasHandler.containsKey(temp)){
                continue;
            }
            int count = 0;
            while(numsMap.containsKey(temp)){
                hasHandler.put(temp,"1");
                if(countMap.containsKey(temp)){
                    count +=countMap.get(temp);
                    break;
                }
                temp++;
                count++;
            }
            countMap.put(nums[i],count);
            max = Math.max(max,count);
        }
        return max;
    }
}
