package com.example.algorithm.twohundred;

import java.util.Arrays;

/**
 * @Auther: cheng
 * @Date: 2020/8/9 11:37
 * @Description: 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 */
public class Subject179 {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return "";
        }
        int length = nums.length;
        String[] strArr = new String[length];
        for(int i=0;i<nums.length;i++){
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr,(o1, o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        StringBuilder sb = new StringBuilder();
        for(String str:strArr){
            sb.append(str);
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
}
