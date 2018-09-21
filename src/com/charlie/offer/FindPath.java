package com.charlie.offer;

import java.util.Stack;
/*
��Ŀ���������к�Ϊĳһֵ��·��(ջ)
����һ����������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·��Ϊ�Ӹ����һֱ��Ҷ��㡣

˼·���Ĳ���1����Ȼ�����������㣬��ô�϶�������������ѽ����ӵ����·���в��ۼ���ֵ��
2��������ʵ��Ľ����Ҷ��㲢��ֵ֮���������������ӡ·����
3�������ǰ��㲻��Ҷ��㣬�ͼ����ݹ�������ӽ�㡣
4����ǰ�����ʽ����󣬵ݹ麯���Զ��ص��丸��㣬�����ں����˳�ǰҪɾ��·���ϵĸý�㲢��ȥ��ֵ��
��֤���ظ����ʱ��·���ǴӸ���㵽����㡣���Կ�������·�������ݽṹ�Ǻ���ȳ���ջ��
 */
public class FindPath {
    public static class Tree{
        int value;
        Tree left;
        Tree right;
    }

    public static void findPath(Tree root,int expectedValue){
        //��һ��ջ��¼·��
        Stack<Integer> path = new Stack<>();
        if(root!=null){
            findPath(root,0,expectedValue,path);
        }
    }

    public static void findPath(Tree root,int curSum,int expectedValue,Stack<Integer> path){
        if (root!=null) {
            //��¼��ǰ·����
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
            //��ǰ����ջ����·�����м�ȥ��ǰ�ڵ�ֵ
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

        // ������·���ϵĽ���Ϊ22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // û��·���ϵĽ���Ϊ15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // ��һ��·���ϵĽ���Ϊ19
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

        // ��һ��·������Ľ���Ϊ15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // û��·������Ľ���Ϊ16
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

        // ��һ��·������Ľ���Ϊ15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // û��·������Ľ���Ϊ16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        // ����ֻ��1�����
        Tree root4 = new Tree();

        root4.value = 1;
        // ��һ��·������Ľ���Ϊ1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // û��·������Ľ���Ϊ2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        // ����û�н��
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
