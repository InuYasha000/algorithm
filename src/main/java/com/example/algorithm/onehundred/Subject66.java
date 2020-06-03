package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/3 00:52
 * @Description:加一
 */
public class Subject66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 1) {
            if (digits[0] + 1 == 10) {
                return new int[]{1, 0};
            } else {
                return new int[]{digits[0] + 1};
            }
        }
        int n = len - 2;
        int index = digits[len - 1] == 9 ? len - 1 : -1;
        while (n >= 0) {
            if (digits[n] == 9 && digits[n + 1] == 9) {
                index = n;
                n--;
            } else {//一旦不符合连续9，立马退出循环
                n = -1;
            }
        }
        if (index == -1) {//没有9
            digits[len - 1] += 1;
            return digits;
        } else if (index == 0) {//全是9
            digits = new int[len + 1];
            digits[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                digits[i] = 0;
            }
            return digits;
        } else {//index到len-1这部分是9
            digits[index - 1] = digits[index - 1] + 1;
            for (int i = index; i < len; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }
}
