package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 21:01
 * @Description:整数转字符串
 */
public class Subject8 {
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        boolean start = false;
        boolean isnegative = false;
        int sum = 0;
        for (char c : ch) {
            if (c == ' ' && !start) {
                continue;
            } else if (c == '-' && !start) {
                isnegative = true;
                start = true;
                continue;
            } else if (c >= '0' && c <= '9') {
                start = true;
                if (sum > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    return isnegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                sum = sum * 10 + c - '0';
            } else if (c == '+' && !start) {
                start = true;
                continue;
            } else {
                if (start) {
                    return isnegative ? sum - 2 * sum : sum;
                }
                return 0;
            }
        }
        return isnegative ? sum - 2 * sum : sum;
    }
}
