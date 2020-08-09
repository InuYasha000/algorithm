package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/9 23:14
 * @Description:岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 */
public class Subject200 {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    res++;
                    marklands(i,j,row,col,grid);
                }
            }
        }
        return res;
    }
    public void marklands(int i,int j,int row,int col,char[][] grid){
        if(i<0||j<0||i>=row||j>=col||grid[i][j]!='1'){
            return;
        }
        grid[i][j] = '2';
        marklands(i-1,j,row,col,grid);
        marklands(i,j+1,row,col,grid);
        marklands(i+1,j,row,col,grid);
        marklands(i,j-1,row,col,grid);
    }
}
