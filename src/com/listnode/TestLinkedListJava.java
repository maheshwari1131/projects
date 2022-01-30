package com.listnode;

import java.util.LinkedList;

public class TestLinkedListJava {

    public static void main(String args[]){

        LinkedList<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.getLast());
        System.out.println(list.pop());


    }
}
