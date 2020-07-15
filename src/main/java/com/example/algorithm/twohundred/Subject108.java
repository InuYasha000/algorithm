package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

/**
 * @Auther: cheng
 * @Date: 2020/7/15 21:02
 * @Description:将有序数组转换为二叉搜索树
 */
public class Subject108 {
    //请注意注释语句，代表的是另一种方式，但太笨了。关键还是中间值的理解并不到位
    public TreeNode sortedArrayToBST(int[] nums) {
        // return sortedArrayToBSTHandler(nums,0,nums.length-1);
        return sortedArrayToBSTHandler(nums,0,nums.length);
    }
    public TreeNode sortedArrayToBSTHandler(int nums[],int left,int right){
        // if(left>right){
        if(left==right){
            return null;
        }
        // int maxindex = (left+right)%2==0?(left+right)/2:(left+right)/2+1;
        int maxindex = (left+right)>>>1;
        TreeNode node = new TreeNode(nums[maxindex]);
        node.left = sortedArrayToBSTHandler(nums,left,maxindex);
//        node.left = sortedArrayToBSTHandler(nums,left,maxindex-1);
        node.right = sortedArrayToBSTHandler(nums,maxindex+1,right);
        return node;
    }
}
