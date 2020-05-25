package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/24 20:16
 * @Description:回溯法
 */
public class Subject37FF {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        solver(board);
    }

    public static boolean solver(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {//从1开始填，不是的话回到上一层
                if (board[i][j] == '.') {
                    char result = '1';
                    while (result <= '9') {
                        if (isValid(board, result, j, i)) {
                            board[i][j] = result;
                            if (solver(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                        result++;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //验证是不是数独
    public static boolean isValid(char[][] board, char target, int col, int row) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == target) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == target) {
                return false;
            }
        }
        int startrow = row / 3 * 3;
        int startcol = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startrow][startcol + j] == target) {
                    return false;
                }
            }
        }
        return true;
    }
}
