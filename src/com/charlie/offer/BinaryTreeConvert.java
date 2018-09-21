package com.charlie.offer;
/*
��Ŀ������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��

����˼·��
�ڶ������У�ÿ����㶼������ָ���ӽ���ָ�롣��˫�������У�ÿ�����Ҳ������ָ�룬���Ƿֱ�ָ��ǰһ�����ͺ�һ����㡣
���������ֽ��Ľṹ���ƣ�ͬʱ����������Ҳ��һ����������ݽṹ��������������п���ʵ�ֶ����������������˫�������ת����
�������������У����ӽ���ֵ����С�ڸ�����ֵ�����ӽ���ֵ���Ǵ��ڸ�����ֵ��
���������ת��������˫������ʱ��ԭ��ָ�����ӽ���ָ�����Ϊ������ָ��ǰһ������ָ�룬
ԭ��ָ�����ӽ���ָ�����Ϊ������ָ���һ�����ָ�롣���������ǿ��Ǹ����ת����

����Ҫ��ת��֮����������ź���ģ����ǿ�������������е�ÿһ����㣬
������Ϊ��������㷨���ص��ǰ��մ�С�����˳�������������ÿһ����㡣��
������������ʱ�����ǰ������������֣�ֵΪ10 �Ľ�㡢�����ֵΪ6 ���������������ֵΪ1 4 ����������
������������Ķ��壬ֵΪ10 �Ľ�㽫�����������������һ����㣨��ֵΪ8 �Ľ�㣩����������
ͬʱ����������������С�Ľ�㣨��ֵΪ12 �Ľ�㣩��������


 */
public class BinaryTreeConvert {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }

    public static BinaryTree convert(BinaryTree root) {
        BinaryTree[] lastNode = new BinaryTree[1];
        convertNode(root, lastNode);
        BinaryTree head = lastNode[0];

        //ͨ���õ����������ǰ��ǰ�����ֱ���ҵ�ͷ�ڵ�
        while (head.left != null && head != null) {
            head = head.left;
        }
        return head;
    }

    //ͨ���������ת������������
    public static void convertNode(BinaryTree node, BinaryTree[] lastNode) {
        if (node != null) {
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }

            node.left = lastNode[0];
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }
            lastNode[0] = node;


            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(BinaryTree head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(BinaryTree root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTree node10 = new BinaryTree();
        node10.value = 10;

        BinaryTree node6 = new BinaryTree();
        node6.value = 6;

        BinaryTree node14 = new BinaryTree();
        node14.value = 14;

        BinaryTree node4 = new BinaryTree();
        node4.value = 4;

        BinaryTree node8 = new BinaryTree();
        node8.value = 8;

        BinaryTree node12 = new BinaryTree();
        node12.value = 12;

        BinaryTree node16 = new BinaryTree();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTree head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTree node1 = new BinaryTree();
        node1.value = 1;

        BinaryTree node2 = new BinaryTree();
        node2.value = 2;

        BinaryTree node3 = new BinaryTree();
        node3.value = 3;

        BinaryTree node4 = new BinaryTree();
        node4.value = 4;

        BinaryTree node5 = new BinaryTree();
        node5.value = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        BinaryTree head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTree node1 = new BinaryTree();
        node1.value = 1;

        BinaryTree node2 = new BinaryTree();
        node2.value = 2;

        BinaryTree node3 = new BinaryTree();
        node3.value = 3;

        BinaryTree node4 = new BinaryTree();
        node4.value = 4;

        BinaryTree node5 = new BinaryTree();
        node5.value = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTree head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // ֻ��һ�����
    private static void test04() {
        BinaryTree node1 = new BinaryTree();
        node1.value = 1;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTree head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // û�н��
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        BinaryTree head = convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
}


