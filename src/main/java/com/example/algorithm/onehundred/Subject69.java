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

    public static int mySqrt1(int x) {
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

    public static int mySqrt(int x) {
        int left = 1, right = x;
        int res = 0;
        int mid = 0, div = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            div = x / mid;
            if (div == mid) {
                return div;
            } else if (mid < div) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
