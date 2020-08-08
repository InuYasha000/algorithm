package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.HashMap;

/**
 * @Auther: cheng
 * @Date: 2020/7/13 23:24
 * @Description:从前序与中序遍历序列构造二叉树
 */
public class Subject105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHandler(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    public TreeNode buildTreeHandler(int []preorder,int []inorder,int pleft,int pright,int ileft,int iright){
        if(pleft==pright){//结束点
            return null;
        }
        int tempVal = preorder[pleft];
        TreeNode root = new TreeNode(tempVal);
        int i=0;
        for(i=ileft;i<iright;i++){//从inorder找到根节点，左边是左子树，右边是右子树
            if(inorder[i]==tempVal){
                break;
            }
        }
        int leftTreeCount = i-ileft+1;
        //pleft+1--前序遍历中左子树的开始地方，也就是左子树的根节点
        //pleft+leftTreeCount--前序遍历中左子树的结束地方，注意这里包含了根节点，但这个参数用作结束，无碍
        //ileft--中序遍历中左子树的开端
        //i--中旭遍历左子树的结束，注意包含了根节点，所以for循环里面是<iright
        root.left = buildTreeHandler(preorder,inorder,pleft+1,pleft+leftTreeCount,ileft,i);
        //pleft+leftTreeCount--前序遍历中右子树的开始地方，也就是右子树的根节点
        //i+1--中序遍历右子树的开端，需要+1
        root.right = buildTreeHandler(preorder,inorder,pleft+leftTreeCount,pright,i+1,iright);
        return root;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHandler2(preorder,inorder,0,preorder.length,0,inorder.length,map);
    }
    public TreeNode buildTreeHandler2(int []preorder,int []inorder,int pleft,int pright,int ileft,int iright,HashMap<Integer,Integer> map){
        if(pleft==pright){//结束点
            return null;
        }
        int tempVal = preorder[pleft];
        TreeNode root = new TreeNode(tempVal);
        int i=0;

        //solution1
        // for(i=ileft;i<iright;i++){//从inorder找到根节点，左边是左子树，右边是右子树
        //     if(inorder[i]==tempVal){
        //         break;
        //     }
        // }

        //solution2
        if(map.containsKey(tempVal)){
            i = map.get(tempVal);
        }
        int leftTreeCount = i-ileft+1;
        //pleft+1--前序遍历中左子树的开始地方，也就是左子树的根节点
        //pleft+leftTreeCount--前序遍历中左子树的结束地方，注意这里包含了根节点，但这个参数用作结束，无碍
        //ileft--中序遍历中左子树的开端
        //i--中旭遍历左子树的结束，注意包含了根节点，所以for循环里面是<iright
        root.left = buildTreeHandler2(preorder,inorder,pleft+1,pleft+leftTreeCount,ileft,i,map);
        //pleft+leftTreeCount--前序遍历中右子树的开始地方，也就是右子树的根节点
        //i+1--中序遍历右子树的开端，需要+1
        root.right = buildTreeHandler2(preorder,inorder,pleft+leftTreeCount,pright,i+1,iright,map);
        return root;
    }
}
