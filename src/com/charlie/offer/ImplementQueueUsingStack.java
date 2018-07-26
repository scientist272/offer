package com.charlie.offer;

import java.util.Stack;

public class ImplementQueueUsingStack {
	/**
	 * 用两个栈模拟的队列 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
	 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
	 * 思路：添加元素即压入一个栈s1，
	 * 删除元素的话，把s1中的元素按顺序先弹出再压入栈s2中，这是弹出栈s2的元素就能实现先进先出了。
	 */

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		queue.appendTail(4);
		queue.appendTail(5);
		System.out.println(queue.deleteHead());
		System.out.println(queue.toString());
	}
}

class Queue {

	// 插入栈，只用于插入的数据
	private Stack<Integer> stack1 = new Stack();

	// 弹出栈，只用于弹出数据
	private Stack<Integer> stack2 = new Stack();

	// 添加操作，成在队列尾部插入结点
	public void appendTail(int elem) {
		stack1.add(elem);
	}

	// 删除操作，在队列头部删除结点
	public int deleteHead() {
		// 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
		// 并且将弹出的数据压入弹出栈中
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
		// 返回弹出栈的栈顶元素，对应的就是队首元素。
		return stack2.pop();
	}

	public void createQueue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		while (!stack2.isEmpty()) {
			buffer.append(stack2.pop().toString());
		}
		String queue = new String(buffer);
		return queue;
	}

}
