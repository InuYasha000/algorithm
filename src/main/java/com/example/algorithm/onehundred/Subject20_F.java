package com.example.algorithm.onehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2020/5/22 23:14
 * @Description:有效的括号
 */
public class Subject20_F {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : ch) {
            if (map.containsKey(c) && !stack.isEmpty()) {
                if (!map.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
