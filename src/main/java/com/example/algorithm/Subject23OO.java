package com.example.algorithm;

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
}
