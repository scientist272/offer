package com.charlie.offer;
/**
 * ����һ����������������е�����k ����㣮Ϊ�˷��ϴ�����˵�ϰ�ߣ�
 * �����1��ʼ�������������β����ǵ�����1����㣮����һ��������6����㣬
 * ��ͷ��㿪ʼ���ǵ�ֵ������1��2��3��4��5 6���������ĵ�����3�������ֵΪ4�Ľ�㣮
 *
 * @param head �����ͷ���
 * @param k    ������k�����
 * @return ������k�����
 *
 * ˼·��Ϊ��ʵ��ֻ��������һ�ξ����ҵ�������k ����㣬���ǿ��Զ�����
��ָ�롣��һ��ָ��������ͷָ�뿪ʼ������ǰ��k-1�����ڶ���ָ�뱣�ֲ�����
�ӵ�k����ʼ���ڶ���ָ��Ҳ��ʼ�������ͷָ�뿪ʼ��������������ָ��ľ��뱣����k-1��
����һ��������ǰ��ģ�ָ�뵽�������β���ʱ���ڶ���ָ�루���ں���ģ�ָ�������ǵ�����k ����㡣
 */

public class FindKthToTail {
    public static class ListNode{
        int value;
        ListNode next;
    }
    public static ListNode findKthToTail(ListNode head, int k){
        // �����������Ϊ�գ�����k����0
        if(head == null||k<1){
                return null;
            }

            ListNode pointer = head;
        // ������k������뵹����һ��������k-1��λ��
        for (int i = 1; i < k; i++) {
            if(head.next!=null){
                head = head.next;
            }
            else {
                return null;// �Ѿ�û�нڵ��ˣ�����i��û�е���k-1˵��k̫��������û����ô���Ԫ��
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

        System.out.println(findKthToTail(head, 1).value); // ������һ��
        System.out.println(findKthToTail(head, 5).value); // �м��һ��
        System.out.println(findKthToTail(head, 9).value); // �������һ������˳����һ��

        System.out.println(findKthToTail(head, 10));
    }
}
