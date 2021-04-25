package com.example.algorithm.onehundred;

import com.example.algorithm.common.ListNode;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 11:33
 * @Description:合并K个排序链表
 */
public class Subject23OO {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
        ListNode[] listNodes = new ListNode[10];
        listNodes[0] = list1;
        listNodes[1] = list4;
        listNodes[2] = list5;
        mergeKLists(listNodes);
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<=1){
            return (lists.length==0?null:lists[0]);
        }
        ListNode head = mergeTwoLists(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode tempResult = new ListNode(0);
        ListNode result = tempResult;
        while(l1!=null||l2!=null){
            if(l1==null){
                tempResult.next = l2;
                l2 = l2.next;
            }else if(l2==null){
                tempResult.next = l1;
                l1 = l1.next;
            }else if(l1.val<l2.val){
                tempResult.next = l1;
                l1 = l1.next;
            }else{
                tempResult.next = l2;
                l2 = l2.next;
            }
            tempResult = tempResult.next;
        }
        return result.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }else if(lists.length==2){
            return merge2Lists1(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode lists1[] = new ListNode[mid];
        ListNode lists2[] = new ListNode[lists.length-mid];
        for(int i=0;i<mid;i++){
            lists1[i] = lists[i];
        }
        for(int i=mid,j=0;i<lists.length;i++,j++){
            lists2[j] = lists[i];
        }
        return merge2Lists1(mergeKLists(lists1),mergeKLists(lists2));
    }
    public ListNode merge2Lists1(ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode res = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while(l1!=null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while(l2!=null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return res.next;
    }
}
