package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/8 18:26
 * @Description:阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 */
public class Subject172 {
    //有多少5的乘法因子
    public int trailingZeroes(int n) {
        int res = 0;
        while(n>0){
            res+=n/5;
            n = n/5;
        }
        return res;
    }
}
