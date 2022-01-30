package com.prac;

import java.util.*;

public class QueueExample {
    public static void main(String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(1);
        q.add(0);
        q.poll();
        System.out.println("The first element is: " + q.peek());
        System.out.println("The size is: " + q.size());

        Queue<Integer> q1=new PriorityQueue<>();
        q1.add(5);
        q1.add(6);
        q1.add(1);
        q1.add(0);
        q1.poll();
        System.out.println("The first element is: " + q1.peek());
        System.out.println("The size is: " + q1.size());

        Stack<Integer> s=new Stack<>();
        s.push(5);
        s.push(6);
        s.push(1);
        s.push(0);
        s.pop();

        System.out.println("The first element is: " + s.peek());
        System.out.println("The size is: " + s.size());



    }
}
