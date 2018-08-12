package com.charlie.offer;

/*
题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
思路：在单链表的表头临时接入一个节点，然后进行尾插法操作。反转单链表。
 */
public class ReverseListNode {
    public static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode reverseListNode(ListNode head) {
        //反转后的头节点
        ListNode reverseHead = null;
        //记录尾插法的当前节点
        ListNode curr = head;
        //要操作的下一节点
        ListNode next = null;
        //尾插法中的头指针
        ListNode pre = null;
        while (curr != null) {

            reverseHead = curr;
            next = curr.next;

            //尾插法
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


