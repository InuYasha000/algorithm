package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/7/23 21:00
 * @Description:杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 图见https://leetcode-cn.com/problems/pascals-triangle/
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Subject118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        res.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=2;j<=i-1;j++){
                list.add(res.get(i-2).get(j-2)+res.get(i-2).get(j-1));
            }
            if(i!=1){
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}
