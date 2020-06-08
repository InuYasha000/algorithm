package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/8 22:21
 * @Description:不同的二叉搜索树
 */
public class Subject96 {
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        if (n == 0) {
            return 0;
        }
        for (int len = 1; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                dp[len] += dp[root - 1] * dp[len - root];
            }
        }
        return dp[n];
    }
}
