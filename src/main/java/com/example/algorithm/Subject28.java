package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 14:22
 * @Description:实现 strStr()
 */
public class Subject28 {
    public static void main(String[] args) {
        System.out.println(10/0);
        strStr("mississippi","issip");
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int j = 0;//j在这里是length，不是index，所以下面应该是i-(j-1)
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }else{
                i = i-j;//这j没有+1，是index，不相等需要回退
                j=0;
            }
            if(j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }
}
