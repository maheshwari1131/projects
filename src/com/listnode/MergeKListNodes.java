package com.listnode;
import java.util.PriorityQueue;

public class MergeKListNodes {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int data){
            this.val=data;

        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for(ListNode n: lists){

            ListNode head=n;
            while(head!=null){
                q.add(head.val);
                head=head.next;

            }
        }
        ListNode n=new ListNode();
        ListNode head=n;

        while(!q.isEmpty()){
            head.next=new ListNode(q.poll());
            head=head.next;
        }
        return n.next;


    }
}
