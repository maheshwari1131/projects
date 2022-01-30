package com.arrays;

import java.util.Iterator;

public class ArrayIm<T> implements Iterable<T>{
    int capacity;
    int length;
    private T[] arr;
    public ArrayIm(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Illegal Argument"+capacity);

        }
        this.capacity=capacity;
        arr=(T[])new Object[capacity];

    }
    public ArrayIm(){
        this(16);
    }

    public int size(){
        return length;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public T get(int index){
        return arr[index];
    }

    public void set(int index, T ele){
        arr[index]=ele;
    }
    public void clear(){
        for(int i=0;i<capacity;i++){
            arr[i]=null;
        }
        length=0;
    }

    public void add(T ele){
        // arr is full of capacity
        if(length==capacity-1){
            capacity=2*capacity;
            T[] newarr=(T[])new Object[capacity];
            for(int i=0;i<length;i++){
                newarr[i]=arr[i];

            }
            arr=newarr;

        }

        arr[length++]=ele;
    }

    public T removeAt(int index){
        if(index>=length){
            throw new IndexOutOfBoundsException();
        }
        T data=arr[index];
        T[] narr=(T[])new Object[capacity-1];
        for(int i=0;i<length;i++){
            if(i==index){
                continue;
            }
            narr[i]=arr[i];

        }
        arr=narr;
        length--;
        capacity--;


        return data;

    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T> (){
            int index=0;
            public boolean hasNext(){return index<length;}
            public T next(){return arr[index++];}
        };
    }
}
