package com.listnode;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class DeleteNodeListNode {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int data) {
            this.val = data;

        }

    }

        public static void main(String args[]){
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        ListNode d=removeNthFromEnd(node,2);

        printListNode(d);


        }

    private static void printListNode(ListNode node) {
        while ((node!=null)){
            System.out.println(node.val+" ");
            node=node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode cur=head;

        for(int i=0;i<n;i++){
            cur=cur.next;

        }
        if(cur==null){
            return head.next;
        }
        System.out.println("CUR");
        printListNode(cur);

        ListNode nodeTobeDelete=head;

        System.out.println("NODE TO DELETE");
        printListNode(nodeTobeDelete);
       while(cur.next!=null){
           System.out.println("cur="+cur.val);
            cur=cur.next;
           System.out.println("nodedelte="+nodeTobeDelete.val);
            nodeTobeDelete=nodeTobeDelete.next;
           System.out.println("nodedelte next="+nodeTobeDelete.next.val);

        }
        System.out.println("AFTER NODE TO DELETE");
        printListNode(nodeTobeDelete);
        nodeTobeDelete.next=nodeTobeDelete.next.next;

        //cur.next.next=cur.next;
        System.out.println("END");
        // from node skip node to be deleted/

        //iterarte untill end

        return head;

        }
    }



