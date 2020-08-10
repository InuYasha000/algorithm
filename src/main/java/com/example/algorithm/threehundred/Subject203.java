package com.example.algorithm.threehundred;

import com.example.algorithm.common.ListNode;

/**
 * @Auther: cheng
 * @Date: 2020/8/10 11:36
 * @Description:移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Subject203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return res.next;
    }
}
