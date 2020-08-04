package com.example.algorithm.twohundred;

import com.example.algorithm.common.ListNode;

/**
 * @Auther: cheng
 * @Date: 2020/8/4 22:48
 * @Description:对链表进行插入排序
 * 图见https://leetcode-cn.com/problems/insertion-sort-list/
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class Subject147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode pre ;
        temp.next = head;
        while(head!=null&&head.next!=null){
            if(head.val<head.next.val){
                head = head.next;
                continue;
            }
            pre = temp;
            while(pre.next.val<head.next.val){
                pre = pre.next;
            }
            ListNode node = head.next;
            head.next = node.next;
            node.next = pre.next;
            pre.next = node;
            //这里不需要head=head.next，因为当前head需要继续和head.next比较，而head.next已经变化了
        }
        return temp.next;
    }
}
