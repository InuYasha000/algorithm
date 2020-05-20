package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 23:03
 * @Description:罗马数字转整数
 * 类似于整数转罗马数字，注意：
 * indexOf判断的必须是第一个字符，substring截取的字符必须要加上b[i].length()
 */
public class Subject13 {
    public static void main(String[] args) {
        romanToInt("III");
    }

    public static int romanToInt(String s) {
        int a[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
        String b[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
        String temp = new String(s);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            while (temp.indexOf(b[i]) == 0) {
                temp = temp.substring(temp.indexOf(b[i]) + b[i].length(), temp.length());
                sum = sum + a[i];
            }
        }
        return sum;
    }
}
