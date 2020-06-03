package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/3 23:11
 * @Description:编辑距离
 * 问题1：如果 word1[0..i-1] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要几步呢？
    答：先使用 k 步，把 word1[0..i-1] 变换到 word2[0..j-1]，消耗 k 步。再把 word1[i] 改成 word2[j]，就行了。如果 word1[i] == word2[j]，什么也不用做，一共消耗 k 步，否则需要修改，一共消耗 k + 1 步。
    问题2：如果 word1[0..i-1] 到 word2[0..j] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
    答：先经过 k 步，把 word1[0..i-1] 变换到 word2[0..j]，消耗掉 k 步，再把 word1[i] 删除，这样，word1[0..i] 就完全变成了 word2[0..j] 了。一共 k + 1 步。
    问题3：如果 word1[0..i] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
    答：先经过 k 步，把 word1[0..i] 变换成 word2[0..j-1]，消耗掉 k 步，接下来，再插入一个字符 word2[j], word1[0..i] 就完全变成了 word2[0..j] 了。
    从上面三个问题来看，word1[0..i] 变换成 word2[0..j] 主要有三种手段，用哪个消耗少，就用哪个。
 */
public class Subject72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 && len2 == 0) {
            return 0;
        }
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int[][] res = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            res[0][i] = i;
        }
        int temp1 = 0, temp2 = 0;
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                temp1 = Math.min(res[i - 1][j], res[i][j - 1]) + 1;
                temp2 = res[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    temp2++;
                }
                res[i][j] = Math.min(temp1, temp2);
            }
        }
        return res[len1][len2];
    }
}
