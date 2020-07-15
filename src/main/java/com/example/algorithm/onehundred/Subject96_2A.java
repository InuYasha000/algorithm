package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/8 22:21
 * @Description:不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 示例:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Subject96_2A {
    //左子树的组合数*右子树的组合数
    //左，右子树分别有多少组合其实就是把左子树和右子树当成单独的根节点树来看
    public int numTrees(int n) {
        //这个dp数组代表的是n个节点的树的组合数
        //理解了dp数组中n代表n个节点的树的个数就能理解下面两个for循环，第一个循环的是n，第二个循环是len个节点下不同根节点时的组合数
        int dp[] = new int[n + 1];
        dp[0] = 1;
        if (n == 0) {
            return 0;
        }
        //长度为len
        for (int len = 1; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                //因为是二叉搜索树，所以左子树小于根节点，又因为是1到n，所以左子树节点数等于根节点数root-1，比如根节点是10，那么左子树则是1.2...9
                dp[len] += dp[root - 1] * dp[len - root];
            }
        }
        return dp[n];
    }
}
