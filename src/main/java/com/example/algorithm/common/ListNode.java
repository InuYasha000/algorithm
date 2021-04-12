package com.example.algorithm.common;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 13:28
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
