package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 00:30
 * @Description:
 */
public class Subject5 {
    public static void main(String[] args) {
//        longestPalindrome3("babad");
        longestPalindrome3("a");
    }

    //找对角线，两个字符串的最大公共子序列也是
    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxlen = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                //长度-1=下标
                if (arr[i][j] > maxlen) {
                    int beforereverse = length - 1 - j;
                    if (beforereverse + arr[i][j] - 1 == i) {
                        maxlen = arr[i][j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end + 1 - maxlen, end + 1);
    }

    public static String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxlen = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    arr[j] = 0;
                }
                //长度-1=下标
                if (arr[j] > maxlen) {
                    int beforereverse = length - 1 - j;
                    if (beforereverse + arr[j] - 1 == i) {
                        maxlen = arr[j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end + 1 - maxlen, end + 1);
    }

    public String longestPalindrome1(String s) {
        char[] ch = s.toCharArray();
        int maxLen = 0;
        int end = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            int len1 = longestPalindromeHelper(ch,i,i);
            int len2 = longestPalindromeHelper(ch,i,i+1);
            maxLen = Math.max(len1,len2);
            if(maxLen>end-start+1){
                start = i-(maxLen-1)/2;
                end = i+maxLen/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int longestPalindromeHelper(char[] ch,int start,int end){
        while(start>=0&&end<ch.length&&ch[start]==ch[end]){
            start--;
            end++;
        }
        return end-start-1;
    }

    public static String longestPalindrome3(String s) {
        int i = 0;
        String res = "";
        int max = 0;
        int left = 0;
        int right = 0;
        while(i<s.length()){
            left = i;
            right = i;
            //单点扩散
            while(left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if(max<right-left+1){
                        max = right-left+1;
                        res = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            left = i;
            right = i;
            //双点扩散
            if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                right = i+1;
                while(left>=0&&right<s.length()){
                    if(s.charAt(left)==s.charAt(right)){
                        if(max<right-left+1){
                            max = right-left+1;
                            res = s.substring(left,right+1);
                        }
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
            }
            i++;
        }
        return res;
    }
}
