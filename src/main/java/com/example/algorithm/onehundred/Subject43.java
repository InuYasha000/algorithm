package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/13 20:44
 * @Description:字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class Subject43 {
    public static void main(String[] args) {
        multiply("123","456");
    }
    public static String multiply(String num1, String num2) {
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        int len1 = ch1.length-1;
        int len2 = ch2.length-1;
        int sums[] = new int[len1+len2+2];
        for(int i=len1;i>=0;i--){
            for(int j=len2;j>=0;j--){
                int temp = (ch1[i]-'0')*(ch2[j]-'0')+sums[i+j+1];
                sums[i+j] += temp/10;
                sums[i+j+1] = temp%10;
            }
        }
        StringBuilder sb = new StringBuilder("");
        int i=0;
        while(sums[i]==0&&i<sums.length-1){
            i++;
        }
        for(;i<sums.length;i++){
            sb.append(sums[i]);
        }
        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        //这里是两个length相加就行了
        int[] sums = new int[ch1.length+ch2.length];
        int temp = 0;
        for(int i=ch1.length-1;i>=0;i--){
            for(int j=ch2.length-1;j>=0;j--){
                //sums最后一位填满
                temp = (ch1[i]-'0')*(ch2[j]-'0')+sums[i+j+1];
                sums[i+j+1] = temp%10;
                sums[i+j] += temp/10;
            }
        }
        int start = 0;
        //小于length-1是因为有个0存在
        while(start<sums.length-1&&sums[start]==0){
            start++;
        }
        StringBuilder sb = new StringBuilder();
        for(;start<sums.length;start++){
            sb.append(sums[start]);
        }
        return sb.toString();
    }
}
