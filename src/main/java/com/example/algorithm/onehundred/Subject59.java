package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/1 22:29
 * @Description:螺旋矩阵 II
 */
public class Subject59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0 || n == 1) {
            res[0][0] = n;
            return res;
        }
        int r[] = {0, 1, 0, -1};
        int c[] = {1, 0, -1, 0};
        int index = 0;
        int rindex = 0, cindex = 0;
        int rnext = 0, cnext = 0;
        for (int i = 1; i <= n * n; i++) {
            res[rindex][cindex] = i;
            rnext = rindex + r[index];
            cnext = cindex + c[index];
            if (rnext >= 0 && rnext < n && cnext >= 0 && cnext < n && res[rnext][cnext] == 0) {
                rindex = rnext;
                cindex = cnext;
            } else {
                index = (index + 1) % 4;
                rindex += r[index];
                cindex += c[index];
            }
        }
        return res;
    }
}
