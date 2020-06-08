package com.example.algorithm.onehundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/6/8 21:13
 * @Description: 二叉树的中序遍历
 */
public class Subject94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // getAns(root,list);
        // return list;

        // List<Integer> list = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode cur = root;
        // while(null!=cur||!stack.isEmpty()){
        //     while(null!=cur){
        //         stack.push(cur);
        //         cur=cur.left;
        //     }
        //     cur=stack.pop();
        //     list.add(cur.val);
        //     cur=cur.right;
        // }
        // return list;

        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left==null){
                list.add(cur.val);
                cur = cur.left;
            }else{
                pre = cur.left;
                while(cur!=null){
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode temp = cur;
                cur = cur.left;
                temp.left = null;
            }
        }
        return list;
    }
    public void getAns(TreeNode node,List<Integer> list){
        if(node==null){
            return ;
        }
        getAns(node.left,list);
        list.add(node.val);
        getAns(node.right,list);
    }
}
