package com.charlie.offer;

import java.util.Stack;

public class ImplementQueueUsingStack {
	/**
	 * ������ջģ��Ķ��� ��������ʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead��
	 * �ֱ�����ڶ���β����������ڶ���ͷ��ɾ�����Ĺ��ܡ�
	 * ˼·�����Ԫ�ؼ�ѹ��һ��ջs1��
	 * ɾ��Ԫ�صĻ�����s1�е�Ԫ�ذ�˳���ȵ�����ѹ��ջs2�У����ǵ���ջs2��Ԫ�ؾ���ʵ���Ƚ��ȳ��ˡ�
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

	// ����ջ��ֻ���ڲ��������
	private Stack<Integer> stack1 = new Stack();

	// ����ջ��ֻ���ڵ�������
	private Stack<Integer> stack2 = new Stack();

	// ��Ӳ��������ڶ���β��������
	public void appendTail(int elem) {
		stack1.add(elem);
	}

	// ɾ���������ڶ���ͷ��ɾ�����
	public int deleteHead() {
		// ���жϵ���ջ�Ƿ�Ϊ�գ����Ϊ�վͽ�����ջ���������ݵ���ջ��
		// ���ҽ�����������ѹ�뵯��ջ��
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
		// ���ص���ջ��ջ��Ԫ�أ���Ӧ�ľ��Ƕ���Ԫ�ء�
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
