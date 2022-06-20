package com.design;
import java.util.Stack;
public class MinStack2 {
    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minstack=new Stack<>();

    public MinStack2(){

    }

    public void push(int x){
        stack.push(x);
        if(minstack.isEmpty()||x<=minstack.peek()){
            minstack.push(x);
        }
    }
}
