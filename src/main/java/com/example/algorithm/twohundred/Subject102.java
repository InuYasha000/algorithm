package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/7/12 12:45
 * @Description: 二叉树的层序遍历
 */
public class Subject102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        DFS(root,0,res);
//        return res;

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        levelOrder(res,root);
        return res;
    }
    public void DFS(TreeNode node,int level,List<List<Integer>> res){
        if(node==null){
            return;
        }
        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        DFS(node.left,level+1,res);
        DFS(node.right,level+1,res);
    }

    public void levelOrder(List<List<Integer>> res,TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count>0){
                list.add(queue.peek().val);
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                queue.poll();
                count--;
            }
            res.add(list);
        }
    }


}
