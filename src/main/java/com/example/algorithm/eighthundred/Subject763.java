package com.example.algorithm.eighthundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cheng
 * @Date: 2021/4/19 21:40
 * @Description:763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 计算所有元素出现的最大下标
 */
public class Subject763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        partitionLabels(s);
    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char ch[] = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ch.length;i++){
            map.put(ch[i],i);
        }
        int end = 0;
        int start = 0;
        for(int i=0;i<ch.length;i++){
            if(map.get(ch[i])!=null){
                end = Math.max(map.get(ch[i]),end);
            }
            if(i==end){
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}
