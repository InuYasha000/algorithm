package com.example.algorithm.onehundred;

import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2021/4/21 08:12
 * @Description:32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject32 {
    //把s各个位置换算成0和1,1表示没有对应括号，0表示有对应括号
    public int longestValidParentheses(String s) {
        int nums[] = new int[s.length()];
        //存放下标
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)).equals("(")){
                stack.push(i);
            }else{
                if(!stack.empty()){
                    nums[i] = 1;
                    nums[stack.pop()] = 1;
                }
            }
        }
        int res = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count+=1;
            }else{
                res = Math.max(res,count);
                count = 0;
            }
        }
        //这里必须也要取值，因为在数组最后连续的1，此时进入不到上面的else逻辑
        res = Math.max(res,count);
        return res;
    }
}
