package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/21 23:08
 * @Description:二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class Subject114 {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){//左子树空，考虑右字树
                root = root.right;
            }else{
                TreeNode temp = root.left;
                while(temp.right!=null){//拿到左子树的最右节点
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
