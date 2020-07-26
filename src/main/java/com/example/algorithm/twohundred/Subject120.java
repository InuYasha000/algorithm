package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/7/25 14:14
 * @Description:三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 */
public class Subject120 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(6,5,7);
        List<Integer> list4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        minimumTotal(list);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int dp[][] = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for(int row=1;row<size;row++){
            int col = 1;
            dp[row][0] = dp[row-1][0] + triangle.get(row).get(0);
            for(;col<triangle.get(row).size()-1;col++){
                dp[row][col] = Math.min(dp[row-1][col-1],dp[row-1][col])+triangle.get(row).get(col);
            }
            dp[row][col] = dp[row-1][col-1]+triangle.get(row).get(col);
        }
        for(int i=0;i<triangle.get(size-1).size();i++){
            min = Math.min(min,dp[size-1][i]);
        }
        return min;
    }

    public int minimumTota2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int dp[][] = new int[rows+1][triangle.get(rows-1).size()+1];
        for(int row=rows-1;row>=0;row--){
            for(int col=0;col<triangle.get(row).size();col++){
                dp[row][col] = Math.min(dp[row+1][col+1],dp[row+1][col]) + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }

    /**
     * size+1是为了自底向上，自顶向下不用+1，但要考虑很多边界
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int dp[] = new int[rows+1];
        for(int row=rows-1;row>=0;row--){
            for(int col=0;col<triangle.get(row).size();col++){
                dp[col] = Math.min(dp[col],dp[col+1])+triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
