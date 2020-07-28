package com.example.algorithm.twohundred;

import java.util.Arrays;

/**
 * @Auther: cheng
 * @Date: 2020/7/28 21:01
 * @Description: 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 */
public class Subject132 {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp,len-1);
        for(int i=0;i<len;i++){
            minCutHandler(s,i,i,dp);
            minCutHandler(s,i,i+1,dp);
        }
        return dp[len-1];
    }
    public void minCutHandler(String s,int left,int right,int dp[]){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            dp[right] = Math.min(dp[right],(left==0?0:dp[left-1]+1));
            left--;
            right++;
        }
    }
}
