package com.charlie.offer;
/*
给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。

思路：一般思路是从头开始遍历，这样复杂度是O(n)不合题意。我们的方法是把该节点的值设为该节点下一个节点的值，然后让该节点指向下下一个节点。
 */

class Node{
    int value;
    Node next;
}
public class DeleteNode {
    public static Node deleteNode(Node head,Node toBeDeleted){
        if(head == null || toBeDeleted == null){
            return head;
        }
        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (head == toBeDeleted) {
            return head.next;
        }
        // 在多个节点的情况下，如果删除的是最后一个元素
        if(toBeDeleted.next == null){
            Node temp = head;
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
        else{
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
            return head;
        }
    }

    public static void printNodeList(Node head){
        while(head!=null){
            System.out.print(head.value+"->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;

        head.next = new Node();
        head.next.value = 2;

        head.next.next = new Node();
        head.next.next.value = 3;

        head.next.next.next = new Node();
        head.next.next.next.value = 4;

        Node middle = head.next.next.next.next = new Node();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.value = 8;

        Node last = head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printNodeList(head);
        Node node = new Node();
        node.value = 12;

        head = deleteNode(head, head); // 删除头结点
        printNodeList(head);
        head = deleteNode(head, last); // 删除尾结点
        printNodeList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printNodeList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        printNodeList(head);
    }

}

