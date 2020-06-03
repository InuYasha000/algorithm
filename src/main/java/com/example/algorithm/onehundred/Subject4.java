package com.example.algorithm.onehundred;

/**
 * @Description: 已知两个有序数组，找到两个数组合并后的中位数。
 * @Date:2020/5/19
 * @Author: Cheng
 */
public class Subject4 {
    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4};
        int b[] = new int[]{1,3,4,5,8};
        findMedianSortedArrays(a,b);
    }
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int left = 0, right = 0, len = m + n, astart = 0, bstart = 0;
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            if (astart < m && (bstart >= m|| a[astart] < b[bstart])) {
                right = a[astart++];
            } else {
                right = b[bstart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
