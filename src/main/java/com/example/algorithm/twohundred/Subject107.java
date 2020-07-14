package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/7/14 22:51
 * @Description:二叉树的层次遍历 II
 */
public class Subject107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        levelOrderBottomHandler(res,root);
        return res;
    }
    public void levelOrderBottomHandler(LinkedList<List<Integer>> res,TreeNode node){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<count;i++){
                list.add(queue.peek().val);
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
            res.addFirst(list);
        }
    }
}
