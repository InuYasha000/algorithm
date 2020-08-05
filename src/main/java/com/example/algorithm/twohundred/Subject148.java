package com.example.algorithm.twohundred;

import com.example.algorithm.common.ListNode;

/**
 * @Auther: cheng
 * @Date: 2020/8/5 20:28
 * @Description:排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class Subject148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast = head.next.next;//这里提前赋值而不是到循环里面去了再赋值目的在于防止两个节点的死循环
        ListNode slow = head;
        ListNode l,r;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        r = mergeSort(slow.next);
        slow.next = null;
        l = mergeSort(head);
        return mergeListNode(l,r);
    }
    public ListNode mergeListNode(ListNode l,ListNode r){
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l!=null&&r!=null){
            if(l.val<r.val){
                temp.next = l;
                l = l.next;
            }else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        temp.next = l==null?r:l;
        return res.next;
    }
}
