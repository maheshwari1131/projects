package com.design;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;


    LRUCache(int capacity){

       super(capacity,0.75f,true);
        this.capacity=capacity;
    }
    public Integer get(int key){

        return this.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        this.put(key,value);
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldes){
        return size()>capacity;
    }

}
