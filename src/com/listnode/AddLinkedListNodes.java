package com.listnode;

public class AddLinkedListNodes {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     */
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int data){
            this.val=data;

        }
    }
    public static void main(String args[]){


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1=l1;
        ListNode p2=l2;
        //created dummy head node
        ListNode finalNode=new ListNode(0);
        int carry=0;
        ListNode cur=finalNode;

        while(p1!=null || p2!=null){
            int x=p1==null?0:p1.val;
            int y= p2==null?0:p2.val;
            int sum=x+y+carry;
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            p1=p1==null?null:p1.next;
            p2=p2==null?null:p2.next;


        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }


        return finalNode.next;


    }
}
