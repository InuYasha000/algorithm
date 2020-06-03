package com.example.algorithm.onehundred;

import com.example.algorithm.common.ListNode;

/**
 * @Description:旋转链表
 * @Date:2020/6/2
 * @Author: Cheng
 */
public class Subject61 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        rotateRight(node,1);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode h = head;
        ListNode tail = h;
        int len = 0;
        while (h != null) {
            h = h.next;
            len++;
            if (h != null) {
                tail = h;
            }
        }
        int n = k % len;
//        if (n == 0) {
//            return head;
//        }
        ListNode fast = head;
        while (n >= 0) {//n>=0为了找出倒数第n+1个节点
            fast = fast.next;
            n--;
        }
        ListNode slow = head;//fast和slow相隔N+1，fast为null时，slow就是倒数第N+1个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        tail.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode h = head;
        ListNode tail = head;//避免[1],1的情况，此时h.next=null,tail也是null
        int len = 0;
        while(h!=null){
            h = h.next;
            len++;
            if(h!=null){
                tail = h;
            }
        }
        int n = k%len;
        // if(n==0){
        //     return head;
        // }
        ListNode fast = head;
        while(n>=0){//n>=0为了找出倒数第n+1个节点
            fast = fast.next;
            n--;
        }
        ListNode slow = head;//fast和slow相隔N+1，fast为null时，slow就是倒数第N+1个节点
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        tail.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
