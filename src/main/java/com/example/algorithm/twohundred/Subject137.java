package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/29 21:15
 * @Description:只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 */

/**
 * 0^x=x x^x=0
 *
 * x&~0=x x&~x=0
 *
 */
public class Subject137 {
    public static void main(String[] args) {
        String s = "www";
        s.substring(0,1);
    }
    public int singleNumber(int[] nums) {
        int a=0,b=0;
        for(int n:nums){
            a = (a^n)&~b;
            b = (b^n)&~a;
        }
        return a;
    }
}
