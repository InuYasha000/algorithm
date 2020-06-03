package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 01:03
 * @Description:
 */
public class Subject7 {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            // int xs = x/10;
            int remainder = x % 10;
            if (sum > Integer.MAX_VALUE / 10) return 0;
            if (sum < Integer.MIN_VALUE / 10) return 0;
            sum = sum * 10 + remainder;
            x = x / 10;
        }
        return sum;
    }

    public int reverse2(int x) {
        long sum = 0;

        while (x != 0) {
            // int xs = x/10;
            int remainder = x % 10;
            // if (sum > Integer.MAX_VALUE/10 ) return 0;
            // if (sum < Integer.MIN_VALUE/10 ) return 0;
            sum = sum * 10 + remainder;
            x = x / 10;
        }
        if (sum > Integer.MAX_VALUE) return 0;
        if (sum < Integer.MIN_VALUE) return 0;
        return (int) sum;
    }
}
