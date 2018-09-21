package com.charlie.offer;
/*
题目：请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。
在复杂链表中，每个结点除了有一个next 域指向下一个结点外，还有一个sibling 指向链表中的任意结点或者null。


 */
public class ComplexListClone {
    public static class ComplexList{
        int value;
        ComplexList next;
        ComplexList sibling;
    }

    //在每个结点之后创建对应的复制结点
    public static void cloneNodes(ComplexList head){
        ComplexList node = head;
        while(node!=null){
            ComplexList clonedNode = new ComplexList();
            clonedNode.value = node.value;
            clonedNode.next = node.next;
            clonedNode.sibling = null;

            node.next = clonedNode;
            node = clonedNode.next;
        }
    }

    //根据原结点的sibling复制它们镜像结点的sibiling
    public static void connectSiblingNodes(ComplexList head){
         ComplexList node = head;
         ComplexList clonedNode = null;
         while(node!=null){
             clonedNode = node.next;
             if(node.sibling!=null){
                clonedNode.sibling = node.sibling.next;
             }
             node = clonedNode.next;
         }
    }

    //将链表分开，即为两个复制的复杂链表
    public static ComplexList reconnectNodes(ComplexList head){
        ComplexList node = head;
        ComplexList clonedHead = null;
        ComplexList clonedNode = null;

        if(node!=null){
            clonedHead =clonedNode= node.next;
            node.next = clonedHead.next;
            node = node.next;
        }

        while(node!=null){
            clonedNode.next = node.next;
            clonedNode = node.next;

            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }

    public static ComplexList complexListClone(ComplexList head){
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    public static void main(String[] args) {
        ComplexList head = new ComplexList();
        head.value = 1;
        ComplexList head1 = new ComplexList();
        head1.value = 2;
        ComplexList head2 = new ComplexList();
        head2.value = 3;
        ComplexList head3 = new ComplexList();
        head3.value = 4;

        head.next = head1;
        head.sibling = head3;

        head1.next = head2;
        head1.sibling = head;

        head2.next = head3;
        head2.sibling = head1;

        head3.next = null;
        head3.sibling = head2;

        System.out.print(head.value+"->"+head.next.value+"->"+head.next.next.value+"->"+head.next.next.next.value);
        System.out.println();
        System.out.print(head.value+"->"+head.sibling.value+"->"+head.next.sibling.value+"->"+head.next.next.sibling.value+"->"+head.next.next.next.sibling.value);
        System.out.println("\nclonedList:");


        ComplexList clonedHead = complexListClone(head);
        System.out.print(clonedHead.value+"->"+clonedHead.next.value+"->"+clonedHead.next.next.value+"->"+clonedHead.next.next.next.value);
        System.out.println();
        System.out.print(clonedHead.value+"->"+clonedHead.sibling.value+"->"+clonedHead.next.sibling.value+"->"+clonedHead.next.next.sibling.value+"->"+clonedHead.next.next.next.sibling.value);

    }
}
