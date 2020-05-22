package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/22 22:12
 * @Description:删除链表的倒数第N个节点
 */
public class Subject19 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        removeNthFromEnd(list1,2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //怎么理解：
    // 1,2,3,4,5 倒数第二个（2），应该是3,5，去除4，倘若判断5.next!=null，那就移动5-3=2（和倒数2相比），就应该是i=0;i<n
    //倘若判断5==null 那就应该是3,5.next 此时就是5.next-3==3(和倒数2比较)，就应该是i=0;i<n+1
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(null==head||head.next==null){
            return null;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;
        ListNode temp1 = result;
        for(int i=0;i<n;i++){//for(int i=0;i<n+1;i++){
            temp = temp.next;
        }
        while(temp.next!=null){//while(temp!=null){
            temp1 = temp1.next;
            temp = temp.next;
        }
        temp1.next = temp1.next.next;
        return result.next;
    }

    public static void print(ListNode listNode){
        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
