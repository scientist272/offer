package com.charlie.offer;
/*
������19���������ľ���(�ݹ�ͷǵݹ�)
����ݹ�͵�Javaʵ�֣�
 */
public class MirrorTreeRecursively {
    public static class Tree{
        int value;
        Tree left;
        Tree right;
        Tree(int value){
            this.value =value;
        }
    }

    public static void mirrorTreeResursively(Tree root){
        if(root !=null){
            Tree temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTreeResursively(root.left);
            mirrorTreeResursively(root.right);
        }
    }

    public static void printTree(Tree root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }

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
        printTree(A1);
        mirrorTreeResursively(A1);
        System.out.println();
        printTree(A1);
    }
}
