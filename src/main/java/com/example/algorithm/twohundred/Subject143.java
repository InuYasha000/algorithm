package com.example.algorithm.twohundred;

import com.example.algorithm.common.ListNode;

import java.util.LinkedList;

/**
 * @Auther: cheng
 * @Date: 2020/8/3 20:59
 * @Description: 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 */
public class Subject143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        reorderList(head);
    }
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode res = head;
        while(res!=null){
            linkedList.addLast(res);
            res = res.next;
        }
        int count = 1;
        res = linkedList.pollFirst();
        while(!linkedList.isEmpty()){
            if(count%2==0){
                res.next = linkedList.pollFirst();
            }else{
                res.next = linkedList.pollLast();
            }
            res = res.next;
            count++;
        }
        res.next = null;
    }
}
