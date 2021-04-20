package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/5/27 23:35
 * @Description:螺旋矩阵
 */
public class Subject54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] istrue = new boolean[m][n];
        int[] r = new int[]{0, 1, 0, -1};//行转弯的数组
        int[] c = new int[]{1, 0, -1, 0};//列转弯的数组
        int rnext = 0, cnext = 0;
        int rindex = 0, cindex = 0;//下一个取值index
        int rcindex = 0;
        int index = 0;//转弯的index
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[rindex][cindex]);
            istrue[rindex][cindex] = true;
            rnext = rindex + r[index];
            cnext = cindex + c[index];
            //下一个要取得值判断
            if (rnext >= 0 && rnext < m && cnext >= 0 && cnext < n && !istrue[rnext][cnext]) {
                rindex = rnext;
                cindex = cnext;
            } else {
                //转弯
                index = (index + 1) % 4;
                rindex += r[index];
                cindex += c[index];
            }
        }
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean isTrue[][] = new boolean[matrix.length][matrix[0].length];
        int r[] = new int[]{0,1,0,-1};//行转弯数组
        int c[] = new int[]{1,0,-1,0};//列转弯数组
        int row = 0;
        int rowNext = 0;
        int col = 0;
        int colNext = 0;
        int index = 0;
        for(int i=0;i<matrix.length*matrix[0].length;i++){
            res.add(matrix[row][col]);
            isTrue[row][col] = true;
            rowNext = row + r[index];
            colNext = col + c[index];
            if(rowNext>=0&&rowNext<matrix.length&&colNext>=0&&colNext<matrix[0].length&&!isTrue[rowNext][colNext]){
                row = rowNext;
                col = colNext;
            }else{
                //转弯
                index++;
                index = index%4;
                row += r[index];
                col += c[index];
            }
        }
        return res;
    }
}
