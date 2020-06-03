package com.example.algorithm;

/**
 * @Description:二进制求和
 * 类似于链表相加
 * @Date:2020/6/3
 * @Author: Cheng
 */
public class Subject67 {
    class Solution {
        public String addBinary(String a, String b) {
            int aindex = a.length()-1,bindex = b.length()-1;
            StringBuilder sb = new StringBuilder();
            int carry = 0,remain = 0,sum = 0;
            while(aindex>=0||bindex>=0){
                if(aindex<0){
                    sum = b.charAt(bindex) - '0' + carry;
                }else if(bindex<0){
                    sum = a.charAt(aindex) - '0' + carry;
                }else{
                    sum = a.charAt(aindex) - '0' + b.charAt(bindex) - '0' + carry;
                }
                aindex --;
                bindex --;
                carry = sum/2;
                remain = sum%2;
                sb.append(remain);
            }
            if(carry==1){
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
}
