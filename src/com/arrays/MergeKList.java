package com.arrays;

import java.util.PriorityQueue;

public class MergeKList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val=val;
        }

        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }

    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode node=new ListNode(0);
        PriorityQueue<Integer> que=new PriorityQueue<>();

        for(ListNode listNode: lists){
            que.add(listNode.val);
            while(!que.isEmpty()){
               node.next=new ListNode(que.poll());
            }
        }
        return node;

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
        ListNode n=new ListNode(q.poll());
        ListNode head=n;

        while(!q.isEmpty()){
            head.next=new ListNode(q.poll());
            head=head.next;

        }

        return n;


    }


}
