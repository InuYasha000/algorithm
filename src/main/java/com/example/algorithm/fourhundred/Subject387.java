package com.example.algorithm.fourhundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cheng
 * @Date: 2021/3/29 20:37
 * @Description:字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 */
public class Subject387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i],1);
            }else{
                map.put(ch[i],0);
            }
        }
        for(int i=0;i<ch.length;i++){
            if(map.get(ch[i])!=1){
                return i;
            }
        }
        return -1;
    }
}
