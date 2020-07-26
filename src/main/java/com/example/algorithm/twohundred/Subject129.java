package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/26 12:03
 * @Description: 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 */
public class Subject129 {
    static int sum = 0;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        TreeNode left = new TreeNode(9);
//        TreeNode right = new TreeNode(0);
//        root.left = left;
//        root.right = right;
//        left.left = new TreeNode(5);
//        right.right = new TreeNode(1);
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        sumNumbers(root);
    }
    public static int sumNumbers(TreeNode root) {
        if(root==null){
            return sum;
        }
        sumNumbersHandler(root,new StringBuffer(root.val+""));
        return sum;
    }
    public static void sumNumbersHandler(TreeNode node,StringBuffer sb){
        if(node.left==null&&node.right==null){
            sum = count(sum,sb.toString());
            return;
        }
        if(node.left!=null){
            sb.append(node.left.val+"");
            sumNumbersHandler(node.left,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(node.right!=null){
            sb.append(node.right.val+"");
            sumNumbersHandler(node.right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static int count(int sum,String s){
        int temp = 1;
        char tempArray[] = s.toCharArray();
        for(int i=tempArray.length-1;i>=0;i--){
            sum+=(tempArray[i]-'0')*temp;
            temp*=10;
        }
        return sum;
    }

    //优化后的解法:
    public int sumNumbers2(TreeNode root) {
        if(root==null){
            return sum;
        }
        sumNumbersHandler2(root,0);
        return sum;
    }
    public void sumNumbersHandler2(TreeNode node,int k){
        if(node==null){
            return ;
        }
        k = k*10+node.val;
        if(node.left==null&&node.right==null){
            sum+=k;
            return;
        }
        sumNumbersHandler2(node.left,k);
        sumNumbersHandler2(node.right,k);
    }
}
