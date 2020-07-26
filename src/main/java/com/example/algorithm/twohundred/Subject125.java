package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/25 22:13
 * @Description:给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 
 */
public class Subject125 {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        int left = 0,right = s.length()-1;
        while(right>=left){
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if(!((cl >= '0' && cl <= '9') || (cl >= 'a' && cl <= 'z') || (cl >= 'A' && cl <= 'Z'))){
                left++;
                continue;
            }
            if(!((cr >= '0' && cr <= '9') || (cr >= 'a' && cr <= 'z') || (cr >= 'A' && cr <= 'Z'))){
                right--;
                continue;
            }
            if((s.charAt(left)&0xDF)==(s.charAt(right)&0xDF)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
