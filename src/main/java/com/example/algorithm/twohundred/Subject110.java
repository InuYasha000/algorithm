package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/20 21:48
 * @Description:平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 */
public class Subject110 {
    // int maxDepth = Integer.MIN_VALUE,minDepth = Integer.MAX_VALUE;
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null){
    //         return true;
    //     }
    //     isBalancedHandler(root,0);
    //     if(Math.abs(maxDepth-minDepth)>1){
    //         return false;
    //     }else{
    //         return true;
    //     }
    // }
    // public void isBalancedHandler(TreeNode node,int depth){
    //     if(node.left==null&&node.right==null){
    //         minDepth = Math.min(minDepth,depth);
    //         return;
    //     }
    //     depth++;
    //     maxDepth = Math.max(depth,maxDepth);
    //     if(node.left!=null){
    //         isBalancedHandler(node.left,depth);
    //     }
    //     if(node.right!=null){
    //         isBalancedHandler(node.right,depth);
    //     }
    //     return;
    // }
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        if(leftDepth>=0&&rightDepth>=0&&Math.abs(leftDepth-rightDepth)<=1){
            return Math.max(leftDepth,rightDepth)+1;
        }else{
            return -1;
        }
    }
}
