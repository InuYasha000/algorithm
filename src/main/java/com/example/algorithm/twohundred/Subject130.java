package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/27 21:20
 * @Description:被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
//从边界出发寻找任何和边界相连并且边界为'O'，用一个特殊支付表示，这些就是实际上没被围绕的,这一点不难想到
//太笨比了，dfs判断边界我一直想的是外面判断，外面判断会导致逻辑很冗余，这个解法亮点在于放到dfs内部去判断
public class Subject130 {
    int row,col;
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        row = board.length;
        col = board[0].length;
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int i=0;i<col;i++){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='1'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    public void dfs(char[][] board,int rowindex,int colindex){
        if(rowindex<0||colindex<0||rowindex>=row||colindex>=col||board[rowindex][colindex]!='O'){
            return;
        }
        board[rowindex][colindex] = '1';
        dfs(board,rowindex-1,colindex);
        dfs(board,rowindex+1,colindex);
        dfs(board,rowindex,colindex-1);
        dfs(board,rowindex,colindex+1);
        return;
    }
}
