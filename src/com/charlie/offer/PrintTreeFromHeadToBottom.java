package com.charlie.offer;

import java.util.LinkedList;
import java.util.Queue;
/*
题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
思路：用队列，当一个结点有子结点时，把子结点添加到队列的末尾，再从队首提取出最早进入的结点。重复这个操作知道队列中的结点被打印完。

 */

public class PrintTreeFromHeadToBottom {
    public static class Tree {
        Tree left;
        Tree right;
        int value;

    }

    public static void printTreeFromHeadToBottom(Tree head) {
        if (head != null) {

            Queue<Tree> queue = new LinkedList<>();
            queue.add(head);

            //记录当前处理结点的指针
            Tree curNode = null;

            while (!queue.isEmpty()) {
                //队首结点出队
                curNode = queue.remove();
                System.out.print(curNode.value + " ");
                //左子树不为空入队
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                //右子树不为空入队
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        Tree root = new Tree();
        root.value = 8;
        root.left = new Tree();
        root.left.value = 6;
        root.left.left = new Tree();
        root.left.left.value = 5;
        root.left.right = new Tree();
        root.left.right.value = 7;
        root.right = new Tree();
        root.right.value = 10;
        root.right.left = new Tree();
        root.right.left.value = 9;
        root.right.right = new Tree();
        root.right.right.value = 11;
        printTreeFromHeadToBottom(root);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        Tree root2 = new Tree();
        root2.value = 1;
        root2.left = new Tree();
        root2.left.value = 3;
        root2.left.left = new Tree();
        root2.left.left.value = 5;
        root2.left.left.left = new Tree();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new Tree();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        printTreeFromHeadToBottom(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        Tree root3 = new Tree();
        root3.value = 0;
        root3.right = new Tree();
        root3.right.value = 2;
        root3.right.right = new Tree();
        root3.right.right.value = 4;
        root3.right.right.right = new Tree();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new Tree();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        printTreeFromHeadToBottom(root3);

        // 1
        Tree root4 = new Tree();
        root4.value = 1;
        System.out.println("\n");
        printTreeFromHeadToBottom(root4);

        // null
        System.out.println("\n");
        printTreeFromHeadToBottom(null);

    }

}

