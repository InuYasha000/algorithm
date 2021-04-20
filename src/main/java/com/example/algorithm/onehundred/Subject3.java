package com.example.algorithm.onehundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: cheng
 * @Date: 2020/5/19 01:52
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Subject3 {
    public static void main(String[] args) {
//        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring1(" ");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s == "") {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, max = 0;
        char[] ch = s.toCharArray();
        for (end = 0; end < ch.length; end++) {
            if (map.containsKey(ch[end])) {
                begin = Math.max(map.get(ch[end]), begin);
                // map.remove(ch[end]);
            }
            max = Math.max(max, end - begin + 1);
            map.put(ch[end], end + 1);
        }
        System.out.println(max);
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s==" "){
            return 1;
        }
        Set<Character> set= new HashSet<>();
        int start = 0;
        int end = 0;
        char[] ch = s.toCharArray();
        int res = 0;
        for(int i=0;i<ch.length;i++){
            if(set.contains(ch[i])){
                res = Math.max((end-start),res);
                start = end;
                set.clear();
            }
            end++;
            set.add(ch[i]);
        }
        return res;
    }
}
