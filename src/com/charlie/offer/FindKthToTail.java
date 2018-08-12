package com.charlie.offer;
/**
 * 输入一个键表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点．例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5 6。这个链表的倒数第3个结点是值为4的结点．
 *
 * @param head 链表的头结点
 * @param k    倒数第k个结点
 * @return 倒数第k个结点
 *
 * 思路：为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两
个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
从第k步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1，
当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。
 */

public class FindKthToTail {
    public static class ListNode{
        int value;
        ListNode next;
    }
    public static ListNode findKthToTail(ListNode head, int k){
        // 输入的链表不能为空，并且k大于0
        if(head == null||k<1){
                return null;
            }

            ListNode pointer = head;
        // 倒数第k个结点与倒数第一个结点相隔k-1个位置
        for (int i = 1; i < k; i++) {
            if(head.next!=null){
                head = head.next;
            }
            else {
                return null;// 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
            }
        }

        while(head.next != null){
            pointer = pointer.next;
            head = head.next;
        }
        return pointer;
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

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

        System.out.println(findKthToTail(head, 10));
    }
}
