package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/3 23:51
 * @Description:矩阵置零
 * 空间复杂度 O(2) ，用两个布尔变量就可以解决。方法就是利用数组的首行和首列来记录 0 值。
 * 从数组下标的 A[1][1] 开始遍历，两个布尔值记录首行首列是否需要置0
 */
public class Subject73 {
    public void setZeroes(int[][] matrix) {
        boolean rowflag = false;
        //判断首行
        for (int i = 0; i < matrix[0].length; i++) {//列长度
            if (matrix[0][i] == 0) {
                rowflag = true;
                break;
            }
        }
        boolean colflag = false;
        //判断首列
        for (int i = 0; i < matrix.length; i++) {//行长度
            if (matrix[i][0] == 0) {
                colflag = true;
                break;
            }
        }
        //将有0的行列置为0,从1开始,首行首列后面单独判断
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //将1行1列为0的全部置为0
        //行
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {//这里j=0有必要
                    matrix[i][j] = 0;
                }
            }
        }
        //列
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //最后判断首行首列
        if (rowflag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colflag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
