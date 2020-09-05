package com.example.algorithm.threehundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: cheng
 * @Date: 2020/9/5 18:54
 * @Description:添加与搜索单词 - 数据结构设计
 * 如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点“。” 点可以与任何字母匹配的地方。
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最调用多 50000 次 addWord 和 search
 *
 */
public class Subject211 {
    class WordDictionary {
        Map<Integer, Set<String>> map = new HashMap<>();
        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            int length = word.length();
            if(map.get(length)==null){
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(length,set);
            }else{
                map.get(length).add(word);
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            Set<String> set = map.get(word.length());
            if(set==null){
                return false;
            }
            if(set.contains(word)){
                return true;
            }
            char[] wch = word.toCharArray();
            P:for(String s:set){
                char[] sch = s.toCharArray();
                for(int i=0;i<sch.length;i++){
                    if(wch[i]!='.'&&wch[i]!=sch[i]){
                        continue P;
                    }
                }
                set.add(word);
                return true;
            }
            return false;
        }
    }
}
