package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cheng
 * @Date: 2020/7/14 22:03
 * @Description: 从中序与后序遍历序列构造二叉树
 */
public class Subject106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int ilength = inorder.length;
        int plength = postorder.length;
        for(int i=0;i<ilength;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHandler(postorder,map,0,inorder.length-1,postorder.length-1);
    }
    public TreeNode buildTreeHandler(int[] postorder,Map<Integer,Integer> map,int ileft,int iright,int pright){
        if(ileft>iright){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pright]);
        int rootIndex = map.get(postorder[pright]);
        int leftTreeCount = rootIndex-ileft;
        root.left = buildTreeHandler(postorder,map,ileft,rootIndex-1,pright-iright+rootIndex-1);
        root.right = buildTreeHandler(postorder,map,rootIndex+1,iright,pright-1);
        return root;
    }
}
