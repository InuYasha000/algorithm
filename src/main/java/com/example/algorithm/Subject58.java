package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/6/1 21:42
 * @Description:最后一个单词的长度
 */
public class Subject58 {
    public int lengthOfLastWord(String s) {
        char ch[] = s.toCharArray();
        int count = 0;
        int lastCount = 0;
        for (char c : ch) {
            if (c == ' ') {
                lastCount = count == 0 ? lastCount : count;
                count = 0;
            } else {
                count++;
            }
        }
        return count == 0 ? lastCount : count;
    }
}
