package com.example.algorithm.onehundred;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: cheng
 * @Date: 2020/5/24 19:21
 * @Description:有效的数独
 */
public class Subject36 {
//第1行数字4  1(4)
//第5列数字3  (5)3
//第n个数独 i/3-j/3(思考数独块在哪)
//这题其实不难，开始没想出来在于题目理解不到位
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String sb = "(" + board[i][j] + ")";
                    if (!set.add(i + sb) || !set.add(sb + j) || !set.add(i / 3 + sb + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
