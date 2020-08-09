package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: cheng
 * @Date: 2020/8/9 11:58
 * @Description:重复的DNA序列
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Subject187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s==null||s.length()<10){
            return res;
        }
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String temp = s.substring(i,i+10);
            if(set.contains(temp)&&!seen.contains(temp)){
                res.add(temp);
                seen.add(temp);
            }
            set.add(temp);
        }
        return res;
    }
}
