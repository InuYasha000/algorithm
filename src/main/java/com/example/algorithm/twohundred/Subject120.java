package com.example.algorithm.twohundred;

import java.util.List;

/**
 * @Description:三角形最小路径和
 * @Date:2020/7/14
 * @Author: Cheng
 */
public class Subject120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // int[][]dp = new int[n+1][n+1];
        // for(int i=n-1;i>=0;i--){
        //     for(int j=0;j<triangle.get(i).size();j++){
        //         dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j])+triangle.get(i).get(j);
        //     }
        // }
        // return dp[0][0];
        int n = triangle.size();
        int []dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
