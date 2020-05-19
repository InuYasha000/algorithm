package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 00:30
 * @Description:
 */
public class Subject5 {
    public static void main(String[] args) {

    }

    //找对角线，两个字符串的最大公共子序列也是
    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxlen = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                //长度-1=下标
                if (arr[i][j] > maxlen) {
                    int beforereverse = length - 1 - j;
                    if (beforereverse + arr[i][j] - 1 == i) {
                        maxlen = arr[i][j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end + 1 - maxlen, end + 1);
    }

    public static String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxlen = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    arr[j] = 0;
                }
                //长度-1=下标
                if (arr[j] > maxlen) {
                    int beforereverse = length - 1 - j;
                    if (beforereverse + arr[j] - 1 == i) {
                        maxlen = arr[j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end + 1 - maxlen, end + 1);
    }
}
