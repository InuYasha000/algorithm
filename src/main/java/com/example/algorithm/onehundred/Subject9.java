package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 21:26
 * @Description:回文数
 */
public class Subject9 {
    public static void main(String[] args) {
        isPalindrome(10);
    }

    public static boolean isPalindrome(int x) {
        int sum = 0;
        int lastSum = 0;
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            while (x != 0) {
                lastSum = sum;
                sum = sum * 10 + x % 10;
                if (sum == 0) {
                    return false;//这种解法就这里一点需要注意
                }
                x = x / 10;
                if (lastSum == x) {
                    return true;
                } else if (sum == x) {
                    return true;
                } else if (sum > x) {
                    return false;
                }
            }
            return false;
        }

    }
}
