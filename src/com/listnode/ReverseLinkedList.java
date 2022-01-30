package com.listnode;

public class ReverseLinkedList {
    private class Node{
        int val;
        Node next;
        Node(){

        }
        Node(int data){
            this.val=data;

        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
