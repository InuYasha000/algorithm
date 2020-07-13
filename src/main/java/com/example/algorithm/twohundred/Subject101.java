package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/7/13 21:37
 * @Description:对称二叉树
 */
public class Subject101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSametricHelper(root.left,root.right);
    }
    public boolean isSametricHelper(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }else if(left==null&&right!=null||left!=null&&right==null){
            return false;
        }else if(left.val!=right.val){
            return false;
        }
        return isSametricHelper(left.left,right.right)&&isSametricHelper(left.right,right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            if(left==null&&right==null){
                continue;//注意这里null的时候需要continue
            }else if(left==null&&right!=null||left!=null&&right==null){
                return false;
            }else if(left.val!=right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(right.left);
            queue.offer(left.right);
        }
        return true;
    }
}
