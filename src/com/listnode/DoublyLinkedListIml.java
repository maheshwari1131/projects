package com.listnode;
import java.lang.Iterable;
import java.util.Iterator;

public class DoublyLinkedListIml <T> implements Iterable<T>{
    int size=0;
    private Node<T> head=null;
    private Node<T> tail=null;
    private class Node<T>{
        T data;
        Node<T> prev,next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data=data;
            this.prev=prev;
            this.next=next;

        }
        @Override
        public String toString(){

            return data.toString();
        }
    }

    public void clear(){
        Node<T> trav=head;
        while(trav!=null){
            trav.data=null;
            Node <T> next=trav.next;
            trav.prev=trav.next=null;
            trav.data=null;
            trav=next;
        }
        head=tail=trav=null;
        size=0;
    }

    public void add(T el){
        addLastEl(el);
    }
    public boolean isEmpy(){
        return size==0;

    }
    public void addLastEl(T el){
        if(isEmpy()){
            head=tail=new Node<>(el,null,null);
        }else{
            tail.next=new Node(el, tail,null);
            tail=tail.next;
        }
        size++;
    }
    public void addFirstEl(T el){
        if(isEmpy()){
            head=tail=new Node<>(el,null,null);
        }else{
            head.prev=new Node(el, null,head);
            head=head.prev;
        }
        size++;
    }
    public T peekFirst(){
        return head.data;
    }
    public T removeFirst(){
        T data=head.data;
        head=head.next;
        size--;
        if(isEmpy()){
            tail=null;
        }else{
            head.prev=null;
        }

        return data;
    }

    public T removeLast(){
        T data=tail.data;
        tail=tail.prev;
        size--;
        if(isEmpy()){
            head=null;
        }else{
            tail.next=null;
        }

        return data;
    }

    public T remove(Node <T> node){
        T data=node.data;
        if(node.prev==null){
            return removeFirst();
        }
        if(node.next==null){
            removeLast();
        }
        node.next.prev=node.next;
        node.prev.next=node.prev;
        node.data=null;
        node=node.prev=node.next=null;
        --size;

        return data;

    }

    public T removeAT(int index){

        if(index<0||index>=size){
            throw new IllegalArgumentException();
        }
        int i=0;
        Node<T> trav;
        if(index<size/2){
            for(i=0,trav=head;i!=index;i++){
                trav=trav.next;

            }
        }else{
            for(i=size-1,trav=tail;i!=index;i--){
                trav=trav.prev;

            }
        }
        return remove(trav);

    }

    public void remove(Object obj){

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        Node<T> trav=head;
        while(trav!=null){
            sb.append(trav.data+",");
            trav=trav.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
