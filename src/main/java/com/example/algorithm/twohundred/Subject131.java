package com.example.algorithm.twohundred;

import java.util.*;

/**
 * @Auther: cheng
 * @Date: 2020/7/27 22:01
 * @Description:
 */
public class Subject131 {
    public static void main(String[] args) {
        partition("aab");
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        Deque<String> path = new ArrayDeque<>();
        partitionHandler(res,s,0,len,path);
        return res;
    }
    public static void partitionHandler(List<List<String>> res,String s,int start,int end,Deque<String> path){
        if(start==end){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<end;i++){
            if(!check(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i+1));
            partitionHandler(res,s,i+1,end,path);
            path.removeLast();
        }
    }
    public static boolean check(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
