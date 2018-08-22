package com.charlie.offer;

import java.util.Stack;
/*
问题:定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的Min函数，在该栈中,min,push,pop的时间复杂度都是O(1)。

思路：用两个栈，一个正常处理，另一个存最小值。入栈时，如果值比最小栈栈顶的值小，则入，否则再入一次最小栈栈顶值。每次取min时就取最小栈栈顶。
 */
public class MinStack {
    public static class StackWithMin<T>{
            Stack<T> dataStack;
            Stack<T> minStack;

            public StackWithMin(){
                this.dataStack = new Stack<>();
                this.minStack = new Stack<>();
            }

            public  T pop(){
                if(!this.dataStack.isEmpty()&&!this.minStack.isEmpty()){
                    this.minStack.pop();
                    return this.dataStack.pop();
                }
                else{

                    return null;
                }
            }

            public void push(T t){
                this.dataStack.push(t);
                if(this.minStack.isEmpty()||(Integer)t<(Integer)this.minStack.peek()){
                    this.minStack.push(t);
                }
                else{
                    this.minStack.push(minStack.peek());
                }
            }


            public void min(){
                if(!this.minStack.isEmpty()){
                    System.out.println(this.minStack.peek());
                }
            }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stackWithMin = new StackWithMin<>();
        stackWithMin.push(1);
        stackWithMin.push(2);
        stackWithMin.push(0);
        stackWithMin.min();
        stackWithMin.pop();
        stackWithMin.min();
    }
}
