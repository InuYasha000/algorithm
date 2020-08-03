package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: cheng
 * @Date: 2020/8/3 21:34
 * @Description:二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 */
public class Subject144 {
    //迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }
    //递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        preorderTraversalHandler(root,res);
        return res;
    }
    public void preorderTraversalHandler(TreeNode node,List<Integer> res){
        if(node.left==null&&node.right==null){
            res.add(node.val);
            return;
        }
        res.add(node.val);
        if(node.left!=null){
            preorderTraversalHandler(node.left,res);
        }
        if(node.right!=null){
            preorderTraversalHandler(node.right,res);
        }
    }
}
