package com.example.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2020/5/22 23:14
 * @Description:有效的括号
 */
public class Subject20 {

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
}
