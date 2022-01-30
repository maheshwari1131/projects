package com.arrays;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueImpl<T> implements Iterable<T> {

    LinkedList<T> list =new LinkedList<>();

    public QueueImpl(){

    }
    public QueueImpl(T firStEl){
        offer(firStEl);
    }

    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }

    // First Element added in Q is returned
    public T peek(){

        return list.peekFirst();

    }
// delete first added element in the queue
    public T poll(){
        return list.removeFirst();
    }

// Add Element to the bCak of the queue

    private void offer(T firStEl) {
        list.addLast(firStEl);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
