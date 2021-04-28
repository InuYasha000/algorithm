package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/3 21:57
 * @Description:爬楼梯
 */
public class Subject70 {
    public int climbStairs(int n) {
        int n1 = 1, n2 = 2;
        if (n == 1) {
            return n1;
        }
        if (n == 2) {
            return n2;
        }
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }
        return n2;
        // return climbCursion(n-1)+climbCursion(n-2);
    }

    public int climbCursion(int n) {//超出时间
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbCursion(n - 1) + climbCursion(n - 2);
    }

    //动态规划
    public int climbStairs1(int n) {
        int dp[] = new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i] = 1;
            }else if(i==n-2){
                dp[i] = 2;
            }else{
                dp[i] = dp[i+1]+dp[i+2];
            }
        }
        return dp[0];
    }
}
