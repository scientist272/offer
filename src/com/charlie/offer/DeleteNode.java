package com.charlie.offer;
/*
�������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ��ɾ���ý�㡣

˼·��һ��˼·�Ǵ�ͷ��ʼ�������������Ӷ���O(n)�������⡣���ǵķ����ǰѸýڵ��ֵ��Ϊ�ýڵ���һ���ڵ��ֵ��Ȼ���øýڵ�ָ������һ���ڵ㡣
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
        // ���ɾ������ͷ��㣬ֱ�ӷ���ͷ������һ�����
        if (head == toBeDeleted) {
            return head.next;
        }
        // �ڶ���ڵ������£����ɾ���������һ��Ԫ��
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

        head = deleteNode(head, null); // ɾ���Ľ��Ϊ��
        printNodeList(head);
        Node node = new Node();
        node.value = 12;

        head = deleteNode(head, head); // ɾ��ͷ���
        printNodeList(head);
        head = deleteNode(head, last); // ɾ��β���
        printNodeList(head);
        head = deleteNode(head, middle); // ɾ���м���
        printNodeList(head);

        head = deleteNode(head, node); // ɾ���Ľ�㲻��������
        printNodeList(head);
    }

}

