package com.example.algorithm.fourhundred;

import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2021/4/22 08:35
 * @Description:316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject316 {
    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
    }
    //入栈，栈顶元素遇到比它小的，并且后面还有相同栈顶元素，那么栈顶肯定要滚蛋
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.contains(s.charAt(i))){
                continue;
            }
            while(!stack.empty()&&stack.peek()>s.charAt(i)&&s.indexOf(stack.peek(),i)!=-1){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        char ch[] = new char[stack.size()];
        for(int i=0;i<stack.size();i++){
            ch[i] = stack.get(i);
        }
        return new String(ch);
    }
}
