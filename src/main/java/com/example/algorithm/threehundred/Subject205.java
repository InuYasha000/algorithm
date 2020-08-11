package com.example.algorithm.threehundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cheng
 * @Date: 2020/8/11 19:36
 * @Description:同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 */
public class Subject205 {
    public boolean isIsomorphic1(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHandler(s,t)&&isIsomorphicHandler(t,s);
    }
    public boolean isIsomorphicHandler(String s,String t){
        int map[] = new int[128];//128个ascii字符
        char []sch = s.toCharArray();
        char []tch = t.toCharArray();
        for(int i=0;i<sch.length;i++){
            if(map[sch[i]]!=0){
                if(map[sch[i]]!=tch[i]){
                    return false;
                }
            }else{
                map[sch[i]] = tch[i];
            }
        }
        return true;
    }
}
