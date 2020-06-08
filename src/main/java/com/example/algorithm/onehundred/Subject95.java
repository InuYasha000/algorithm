package com.example.algorithm.onehundred;

import com.example.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/6/8 21:52
 * @Description:不同的二叉搜索树 II
 */
public class Subject95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start;i <= end;i++){
            List<TreeNode> subLeftTree = generateTrees(start,i-1);
            List<TreeNode> subRightTree = generateTrees(i+1,end);
            for(TreeNode left : subLeftTree){
                for(TreeNode right : subRightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
