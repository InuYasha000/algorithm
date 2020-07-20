package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/20 22:28
 * @Description:二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class Subject111 {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left!=null&&node.right!=null){
            return Math.min(getMinDepth(node.left),getMinDepth(node.right))+1;
        }else{
            return Math.max(getMinDepth(node.left),getMinDepth(node.right))+1;
        }
    }
}
