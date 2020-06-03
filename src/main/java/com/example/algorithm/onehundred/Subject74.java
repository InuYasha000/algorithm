package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/4 00:24
 * @Description:搜索二维矩阵
 */
public class Subject74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        int left = 0, right = cols * rows - 1, mid = 0, temp = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            temp = matrix[mid / cols][mid % cols];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
