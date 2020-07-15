package com.example.algorithm.twohundred;

import com.example.algorithm.common.ListNode;
import com.example.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/7/15 21:40
 * @Description:有序链表转换二叉搜索树
 */
public class Subject109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBSTHandler(list,0,list.size());
//        return sortedListToBSTHandler2(head,null);
    }
    public TreeNode sortedListToBSTHandler(List<Integer> list,int left,int right){
        if(left==right){
            return null;
        }
        int mid = (left+right)>>>1;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBSTHandler(list,left,mid);
        node.right = sortedListToBSTHandler(list,mid+1,right);
        return node;
    }

    public TreeNode sortedListToBSTHandler2(ListNode head,ListNode tail){
        if(head==tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail&&fast.next!=tail){//注意这里并不是null，原因在于递归层次中并不是会有null值
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBSTHandler2(head,slow);
        node.right = sortedListToBSTHandler2(slow.next,tail);
        return node;
    }
}
