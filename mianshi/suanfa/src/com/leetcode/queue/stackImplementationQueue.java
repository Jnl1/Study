package com.leetcode.queue;

import java.util.Stack;
//232  LeetCode
public class stackImplementationQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public stackImplementationQueue() {

    }
    public void push(int x){
        inStack.push(x);
    }

    public int pop(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    public int peek(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    public boolean empty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
