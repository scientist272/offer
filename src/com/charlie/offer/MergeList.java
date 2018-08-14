package com.charlie.offer;

public class MergeList {
    /*
    题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     */
    public static class ListNode{
        int value;
        ListNode next;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */

    public static ListNode mergeList(ListNode head1,ListNode head2){
        // 如果第一个链表为空，返回第二个链表头结点
        if(head1 == null){
            return head2;
        }
        // 如果第二个结点为空，返回第一个链表头结点
        if(head2 == null){
            return head1;
        }
        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;
        // 当两个链表都不为空就进行合并操作
        while(head1 != null && head2 !=null){
            // 下面的操作合并较小的元素
            if(head1.value<head2.value){
                pointer.next = head1;
                head1 = head1.next;
            }

            else{
                pointer.next = head2;
                head2 = head2.next;
            }
            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }
        // 下面的两个if有且只一个if会内的内容会执行

        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if(head1 == null){
            pointer.next = head2;
        }
        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if(head2 == null){
            pointer.next = head1;
        }
        // 返回处理结果
        return root.next;
    }

    public static void printList(ListNode list){
        while(list !=null ){
            System.out.print(list.value+"->");
            list = list.next;
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;


        head = mergeList(head, head2);
        printList(head);
    }
}
