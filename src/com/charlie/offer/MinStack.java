package com.charlie.offer;

import java.util.Stack;
/*
����:����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�Min�������ڸ�ջ��,min,push,pop��ʱ�临�Ӷȶ���O(1)��

˼·��������ջ��һ������������һ������Сֵ����ջʱ�����ֵ����Сջջ����ֵС�����룬��������һ����Сջջ��ֵ��ÿ��ȡminʱ��ȡ��Сջջ����
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
