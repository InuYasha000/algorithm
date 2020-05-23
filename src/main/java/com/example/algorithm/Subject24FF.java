package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 13:28
 * @Description:两两交换链表中的节点
 */
public class Subject24FF {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        swapPairs(node1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head;
        ListNode tempResult = new ListNode(0);
        ListNode result = tempResult;
        boolean isfirst = false;
        while (temp != null || temp1 != null) {
            if (isfirst) {
                tempResult.next = temp;
                temp = temp.next == null ? null : temp.next.next;
                isfirst = false;
            } else {
                tempResult.next = temp1.next;
                temp1 = temp1.next == null ? null : temp1.next.next;
                isfirst = true;
            }
            tempResult = tempResult.next;
        }
        return result.next;
    }
}
