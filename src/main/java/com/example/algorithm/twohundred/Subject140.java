package com.example.algorithm.twohundred;

import java.util.*;

/**
 * @Auther: cheng
 * @Date: 2020/7/30 21:28
 * @Description:
 */
public class Subject140 {
    public static void main(String[] args) {
        wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        boolean []dp = new boolean[len+1];
        dp[0] = true;
        Map<String,String> map = new HashMap<>();
        for(String str:wordDict){
            map.put(str,"1");
        }
        Map<Integer,List<String>> resMap = new HashMap<>();
        resMap.put(0,new ArrayList<>(Arrays.asList("")));
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                boolean flag = dp[j]&&map.containsKey(s.substring(j,i));
                if(!dp[i]){
                    dp[i] = flag;
                }
                if(flag){
                    List<String> temp = new ArrayList<>(resMap.get(j));
                    if(null==temp){
                       temp = new ArrayList<>();
                    }
                    temp.add(" "+s.substring(j,i));
                    if(resMap.containsKey(i)){
                        resMap.put(i,temp);
                    }else{
                        resMap.put(i,temp);
                    }
                }
            }
        }
        return resMap.get(len);
    }
}
