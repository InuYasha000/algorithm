package com.example.algorithm.threehundred;

import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2021/4/22 07:56
 * @Description:224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject224 {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                int cur = ch[i]-'0';
                while(i+1<ch.length&&ch[i+1]>='0'&&ch[i+1]<='9'){
                    cur = cur*10 + ch[++i]-'0';
                }
                res += sign * cur;
            }else if(ch[i]=='+'){
                sign = 1;
            }else if(ch[i]=='-'){
                sign = -1;
            }else if(ch[i]=='('){
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            }else if(ch[i]==')'){
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
