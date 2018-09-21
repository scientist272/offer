package com.charlie.offer;
/*
题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。

解题思路：
在后序遍历得到的序列中， 最后一个数字是树的根结点的值。数组中前面的数字可以分为两部分： 第一部分是左子树结点的值，它们都比根结点的值小：
第二部分是右子树结点的值，它们都比根结点的值大。
 */
public class VerifySequenceOfBST {
    public static boolean verifySequenceOfBST(int[] array){
        return verifySequenceOfBST(array,0,array.length-1);
    }
    public static boolean verifySequenceOfBST(int[] array,int start,int end){
        // 如果对应要处理的数据只有一个或者已经没有数据要处理（start>end）就返回true
        if(start>=end){
            return true;
        }

        if(array.length==0||array==null){
            return  false;
        }

        int index = start;
        //寻找右子树根节点
        while(index<end-1 && array[index]<array[end]){
            index++;
        }
        //记录右子树根节点的位置
        int right = index;
        //如果右子树不能遍历到最后则不符合二叉搜索树要求
        while(index<end-1 && array[index]>array[end]){
            index ++;
        }
        //如果右子树不能遍历到最后则不符合二叉搜索树要求
        if(index != end-1){
            return false;
        }
        //右子树根节点作为递归的分界线
        index = right;

        return verifySequenceOfBST(array,start,index-1)&&verifySequenceOfBST(array,index,end-1);
    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }
}
