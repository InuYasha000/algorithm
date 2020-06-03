package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 11:32
 * @Description:括号生成
 */
public class Subject22 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n);
        return result;
    }

    public void generate(int left, int right, int length) {
        if (sb.length() == 2 * length) {
            result.add(sb.toString());
            return;
        }
        if (left < length) {
            sb.append("(");
            generate(left + 1, right, length);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {//右括号始终要比左括号小，不然当sb减到一定程度时，右括号会跑到左括号前面
            // if(right<length){
            sb.append(")");
            generate(left, right + 1, length);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
