package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/25 23:32
 * @Description:字符串相乘
 */
public class Subject44 {
    public static void main(String[] args) {
        multiply("123", "456");
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int m = num2.charAt(i) - '0';
            int carry = 0;//进位
            String result_part = "";//结果集
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n = num1.charAt(j) - '0';
                int sum = m * n + carry;
                carry = sum / 10;
                result_part = sum % 10 + "" + result_part;
            }
            if (carry > 0) {
                result_part = carry + "" + result_part;
            }
            for (int index = 0; index < num2.length() - 1 - i; index++) {//如果当前位不是个位，需要+'0'
                result_part = result_part + '0';
            }
            result = sum(result_part, result);
        }
        return result;
    }

    public static String sum(String nums1, String nums2) {
        int m = nums1.length() - 1;
        int n = nums2.length() - 1;
        int carry = 0;
        int num1_part = 0;
        int num2_part = 0;
        int sum = 0;
        String remain = "";
        while (m >= 0 || n >= 0) {
            num1_part = m >= 0 ? nums1.charAt(m) - '0' : 0;
            num2_part = n >= 0 ? nums2.charAt(n) - '0' : 0;
            sum = num1_part + num2_part + carry;
            carry = sum / 10;
            remain = sum % 10 + "" + remain;//看清楚这是字符串
            m--;
            n--;
        }
        if (carry > 0) {
            remain = carry + "" + remain;
        }
        return remain;
    }
}
