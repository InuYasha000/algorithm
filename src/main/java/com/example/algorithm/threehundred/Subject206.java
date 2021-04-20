package com.example.algorithm.threehundred;

import com.example.algorithm.common.ListNode;

import java.util.HashSet;

/**
 * @Auther: cheng
 * @Date: 2020/8/11 20:37
 * @Description:反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
public class Subject206 {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode node = temp.next;
            temp.next = res;
            res = temp;
            temp = node;
        }
        return res;
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode next = cur.next;
        while(next!=null){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return pre.next;
    }
}
