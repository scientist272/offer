package com.charlie.offer;
/*
面试题18：树的子结构(递归)
判断二叉树B是不是二叉树A的子树.

思路：思路：两步：1，递归调用hasSubtree先遍历A中有没有结点的值和B的根结点相同，如果有，
调用match做第二步判断。2，判断AB结构是否相同，即递归判断左右结点。
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
