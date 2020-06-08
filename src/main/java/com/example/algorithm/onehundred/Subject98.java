package com.example.algorithm.onehundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/6/8 22:33
 * @Description:验证二叉搜索树
 */
public class Subject98 {
        public boolean isValidBST(TreeNode root) {
            return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        public boolean valid(TreeNode node,long min,long max){
            if(node==null){
                return true;
            }
            if(node.val<=min||node.val>=max){
                return false;
            }
            return valid(node.left,min,node.val)&&valid(node.right,node.val,max);
        }
}
