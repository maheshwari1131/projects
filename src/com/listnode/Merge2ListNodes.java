package com.listnode;
import java.util.PriorityQueue;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 */
public class Merge2ListNodes {

    private class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int data){
            this.val=data;

        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        ListNode dum=new ListNode(0);

        ListNode head=dum;

        while(list1!=null ||list2!=null){

            if(list1!=null){
                queue.add(list1.val);
                list1=list1.next;

            }
            if(list2!=null){

                queue.add(list2.val);
                list2=list2.next;
            }


        }

        while(queue.size()!=0){
            head.next=new ListNode(queue.poll());
            head=head.next;


        }

        return dum.next;


    }

}
