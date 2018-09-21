package com.charlie.offer;

import java.util.Stack;
/*
题目：二叉树中和为某一值的路径(栈)
输入一个二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径，路径为从根结点一直到叶结点。

思路：四步，1，既然是先输出根结点，那么肯定是先序遍历，把结点添加到输出路径中并累加其值，
2，如果访问到的结点是叶结点并且值之和满足条件，则打印路径，
3，如果当前结点不是叶结点，就继续递归访问其子结点。
4，当前结点访问结束后，递归函数自动回到其父结点，所以在函数退出前要删掉路径上的该结点并减去其值，
保证返回父结点时的路径是从根结点到父结点。可以看出保存路径的数据结构是后进先出的栈。
 */
public class FindPath {
    public static class Tree{
        int value;
        Tree left;
        Tree right;
    }

    public static void findPath(Tree root,int expectedValue){
        //用一个栈记录路径
        Stack<Integer> path = new Stack<>();
        if(root!=null){
            findPath(root,0,expectedValue,path);
        }
    }

    public static void findPath(Tree root,int curSum,int expectedValue,Stack<Integer> path){
        if (root!=null) {
            //记录当前路径和
            curSum += root.value;
            path.push(root.value);
            if(curSum<expectedValue){
                findPath(root.left,curSum,expectedValue,path);
                findPath(root.right,curSum,expectedValue,path);
            }
            else if(curSum==expectedValue){
                if(root.left==null&&root.right==null){
                    System.out.println(path);
                }
            }
            //当前结点出栈并在路径和中减去当前节点值
            path.pop();
            curSum-=root.value;
        }
    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        Tree root = new Tree();
        root.value = 10;
        root.left = new Tree();
        root.left.value = 5;
        root.left.left = new Tree();
        root.left.left.value = 4;
        root.left.right = new Tree();
        root.left.right.value = 7;
        root.right = new Tree();
        root.right.value = 12;

        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);


        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        Tree root2 = new Tree();
        root2.value = 5;
        root2.left = new Tree();
        root2.left.value = 4;
        root2.left.left = new Tree();
        root2.left.left.value = 3;
        root2.left.left.left = new Tree();
        root2.left.left.left.value = 2;
        root2.left.left.left.left = new Tree();
        root2.left.left.left.left.value = 1;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 16);");
        findPath(root2, 16);

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        Tree root3 = new Tree();
        root3.value = 1;
        root3.right = new Tree();
        root3.right.value = 2;
        root3.right.right = new Tree();
        root3.right.right.value = 3;
        root3.right.right.right = new Tree();
        root3.right.right.right.value = 4;
        root3.right.right.right.right = new Tree();
        root3.right.right.right.right.value = 5;

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        // 树中只有1个结点
        Tree root4 = new Tree();

        root4.value = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
