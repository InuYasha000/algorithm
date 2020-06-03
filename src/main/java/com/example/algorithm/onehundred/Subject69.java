package com.example.algorithm.onehundred;

/**
 * @Description:x 的平方根
 * @Date:2020/6/3
 * @Author: Cheng
 */
public class Subject69 {
    public static void main(String[] args) {
        mySqrt(Integer.MAX_VALUE);
        Math.sqrt(Integer.MAX_VALUE);
    }
    public static int mySqrt(int x) {
        int left = 0, right = x;
        return dictotomy(left, right, x);
    }

    public static int dictotomy(int left, int right, int target) {
        int temp = (left + right) / 2;
        if (temp * temp == target) {
            return temp;
        } else if ((temp + 1) * (temp + 1) == target) {
            return temp + 1;
        } else if (temp * temp < target && (temp + 1) * (temp + 1) > target) {
            return temp;
        } else if (temp * temp < target) {
            return dictotomy(temp, right, target);
        } else {
            return dictotomy(left, temp, target);
        }
    }
}
