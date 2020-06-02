package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/6/2 22:49
 * @Description:不同路径
 */
public class Subject62 {
    public static void main(String[] args) {
        uniquePath2(3,2);
    }
    public static int uniquePaths1(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
    public static int uniquePath2(int m, int n){
        int N = m+n-2;
        int k = m-1;
        long res = 1;//必须是long，不然小数就没了小数位
        for(int i=1;i<=k;i++){
            res =res* (N-k+i)/i;//这里必须res* 不能*=，否则3/2这种会是1
        }
        return (int)res;
    }
}
