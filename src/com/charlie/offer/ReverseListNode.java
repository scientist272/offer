package com.charlie.offer;

/*
��Ŀ������һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
˼·���ڵ�����ı�ͷ��ʱ����һ���ڵ㣬Ȼ�����β�巨��������ת������
 */
public class ReverseListNode {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverseListNode(ListNode head) {
        //��ת���ͷ�ڵ�
        ListNode reverseHead = null;
        //��¼β�巨�ĵ�ǰ�ڵ�
        ListNode curr = head;
        //Ҫ��������һ�ڵ�
        ListNode next = null;
        //β�巨�е�ͷָ��
        ListNode pre = null;
        while (curr != null) {

            reverseHead = curr;
            next = curr.next;

            //β�巨
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return reverseHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseListNode(head);
        printList(head);


    }
}


