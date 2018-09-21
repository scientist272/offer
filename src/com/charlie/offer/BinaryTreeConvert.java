package com.charlie.offer;
/*
题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

解题思路：
在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。
由于这两种结点的结构相似，同时二叉搜索树也是一种排序的数据结构，因此在理论上有可能实现二叉搜索树和排序的双向链表的转换。
在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总是大于父结点的值。
因此我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
原先指向右子结点的指针调整为链表中指向后一个结点指针。接下来我们考虑该如何转换。

由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点，
这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。当
遍历到根结点的时候，我们把树看成三部分：值为10 的结点、根结点值为6 的左子树、根结点值为1 4 的右子树。
根据排序链表的定义，值为10 的结点将和它的左子树的最大一个结点（即值为8 的结点）链接起来，
同时它还将和右子树最小的结点（即值为12 的结点）链接起来


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

        //通过得到的最后结点往前找前驱结点直到找到头节点
        while (head.left != null && head != null) {
            head = head.left;
        }
        return head;
    }

    //通过中序遍历转换二叉搜索树
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

    // 只有一个结点
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

    // 没有结点
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


