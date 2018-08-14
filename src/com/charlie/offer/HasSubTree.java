package com.charlie.offer;
/*
������18�������ӽṹ(�ݹ�)
�ж϶�����B�ǲ��Ƕ�����A������.

˼·��˼·��������1���ݹ����hasSubtree�ȱ���A����û�н���ֵ��B�ĸ������ͬ������У�
����match���ڶ����жϡ�2���ж�AB�ṹ�Ƿ���ͬ�����ݹ��ж����ҽ�㡣
 */
public class HasSubTree {
    public static class Tree{
        int value;
        Tree left;
        Tree right;
        Tree(int value){
            this.value =value;
        }
    }

    public static boolean match(Tree root1, Tree root2){

        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        if(root1.value != root2.value){
            return false;
        }

        return match(root1.left,root2.left) && match(root1.right, root2.right);

    }

    public static boolean hasSubTree(Tree root1, Tree root2){
        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        if(root1.value == root2.value){
            return match(root1,root2);
        }

        return hasSubTree(root1.left,root2) || hasSubTree(root1.right,root2);
    }

    public static void main(String[] args) {
        Tree A1 = new Tree(0);
        Tree A2 = new Tree(1);
        Tree A3 = new Tree(2);
        Tree A4 = new Tree(3);
        Tree A5 = new Tree(4);
        A1.left = A2;
        A1.right = A3;
        A2.left = A4;
        A2.right = A5;
        Tree B1 = new Tree(1);
        Tree B2 = new Tree(3);
        Tree B3 = new Tree(4);
        B1.left = B2;
        B1.right = B3;
        System.out.println(hasSubTree(A1, B1));

    }
}
