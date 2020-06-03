package com.example.algorithm.onehundred;

import com.example.algorithm.common.ListNode;

/**
 * @Auther: cheng
 * @Date: 2020/5/22 23:30
 * @Description:合并两个有序链表
 */
public class Subject21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}
