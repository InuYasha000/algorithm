package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/20 23:03
 * @Description:路径总和 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * v
 */
public class Subject112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum != 0) {
            return false;
        }
        if (root == null && sum == 0) {
            return false;
        }
        return hasPathSumHandler(root, sum);
    }

    public boolean hasPathSumHandler(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null) {
            if (node.val != targetSum) {
                return false;
            } else {
                return true;
            }
        }
        if (node.left == null) {
            return hasPathSumHandler(node.right, targetSum - node.val);
        }
        if (node.right == null) {
            return hasPathSumHandler(node.left, targetSum - node.val);
        }
        return hasPathSumHandler(node.left, targetSum - node.val) || hasPathSumHandler(node.right, targetSum - node.val);
    }
}
