package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 22:51
 * @Description:整数转罗马数字
 * 就是让数字和字母对应起来，同时还是大到小的顺序
 */
public class Subject12 {
    public String intToRoman(int num) {
        if (num >= 1 && num <= 3999) {
            //map不可以，map没有顺序
            int a[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
            String b[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                while (num >= a[i]) {
                    num = num - a[i];
                    result.append(b[i]);
                }
            }
            return result.toString();
        } else {
            return "";
        }
    }
}
