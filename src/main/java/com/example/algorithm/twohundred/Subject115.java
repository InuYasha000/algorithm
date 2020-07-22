package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/22 22:13
 * @Description:不同的子序列
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "rabbbit", T = "rabbit"
 * 输出：3
 * 解释：
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 *
 * 输入：S = "babgbag", T = "bag"
 * 输出：5
 * 解释：
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 */
public class Subject115 {
    public int numDistinct(String s, String t) {
        //dp[i][j]表示s长度为i，t长度为j时结果
        int dp[][] = new int[s.length()+1][t.length()+1];//初始化就是0,这样s长度为0时不用额外赋值(全都是0)
        for(int i=0;i<=s.length();i++){//需要对t长度为0全部赋值为1,这个i代表s的长度
            dp[i][0] = 1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(j>i){
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];//s的新加字符是否和t新加字符比较，是的话就是上一个值，否则代表t的新长度在s的旧长度里面的匹配
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
