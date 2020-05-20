package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 23:43
 * @Description:最长公共前缀
 * 取第一个str,从第一个字符开始一次到后面的str里面去比较
 * 比较点：是否相等，以及长度是否超出（长度超出需要在相等前面进行比较）
 */
public class Subject14 {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"aa","a"});
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {//比较第一行以及后面
                if (i == strs[j].length()||strs[j].charAt(i) != strs[0].charAt(i)  ) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
