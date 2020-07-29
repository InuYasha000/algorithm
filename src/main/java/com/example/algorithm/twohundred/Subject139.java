package com.example.algorithm.twohundred;

import java.util.*;

/**
 * @Auther: cheng
 * @Date: 2020/7/29 21:56
 * @Description:单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */
public class Subject139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordList = Arrays.asList("leet","code");
        wordBreak(s,wordList);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String,String> map = new HashMap<>();
        for(String str:wordDict){
            map.put(str,"1");
        }
        boolean dp[] = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                dp[i]=dp[j]&&map.containsKey(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
