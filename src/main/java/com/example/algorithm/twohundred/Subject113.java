package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/7/21 22:35
 * @Description: 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class Subject113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        pathSumHandler(root,res,sum,new ArrayList<>());
        return res;
    }

    public void pathSumHandler(TreeNode node,List<List<Integer>> res,int sum,List<Integer> temp){
        if(node.left==null&&node.right==null){
            if(node.val!=sum){
                return;
            }else{
                temp.add(node.val);
                res.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
                return;
            }
        }
        temp.add(node.val);
        if(node.left==null){
            // temp.add(node.val);
            pathSumHandler(node.right,res,sum-node.val,temp);
            temp.remove(temp.size()-1);
            return;
        }
        if(node.right==null){
            // temp.add(node.val);
            pathSumHandler(node.left,res,sum-node.val,temp);
            temp.remove(temp.size()-1);
            return;
        }
        // temp.add(node.val);
        pathSumHandler(node.left,res,sum-node.val,temp);
        // temp.remove(temp.size()-1);
        // temp.add(node.val);
        pathSumHandler(node.right,res,sum-node.val,temp);
        temp.remove(temp.size()-1);
    }
}
