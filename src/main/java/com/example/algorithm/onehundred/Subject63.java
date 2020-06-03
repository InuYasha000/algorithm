package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/2 23:31
 * @Description:不同路径 II
 */
public class Subject63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //不用判断，因为res[m-1][n-1]就是0。
//        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){//入口和出口有障碍，这题无解
//            return 0;
//        }
        int res[][] = new int[m][n];//默认都是0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                res[i][0] = 0;//后面不用赋值为1了
                break;
            } else {
                res[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                res[0][i] = 0;
                break;
            } else {
                res[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {//第0行第0列都已经有数据了，所以不需要再加入进来
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}
