package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/7/12 13:03
 * @Description: 二叉树的锯齿形层次遍历
 */
public class Subject103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        DFS(res,root,0);
//        return res;

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        levelOrder(res,root);
        return res;
    }
    public void DFS(List<List<Integer>> res,TreeNode node,int level){
        if(node==null){
            return;
        }
        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        if(level%2==0){
            res.get(level).add(node.val);
        }else{
            res.get(level).add(0,node.val);
        }
        DFS(res,node.left,level+1);
        DFS(res,node.right,level+1);
    }

    public void levelOrder(List<List<Integer>> res,TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count>0){
                if(num%2==0){
                    list.add(queue.peek().val);
                }else{
                    list.add(0,queue.peek().val);
                }
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
            num++;
        }
    }
}
