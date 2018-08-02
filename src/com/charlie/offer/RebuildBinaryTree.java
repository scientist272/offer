package com.charlie.offer;

public class RebuildBinaryTree {
	 /**
	  * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
	  * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	  * 例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝
	  * 和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建出下图所示的二叉树并输出它的头结点。
     * 二叉树节点类
     */
	public static class BinaryTree{
		int value;
		BinaryTree left;
		BinaryTree right;
	}
	

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return 树的根结点
     */
  
	public static BinaryTree construct(int[] preOrder,int[] inOrder){

		return construct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preOrder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inOrder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    
	private static BinaryTree construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
		 // 开始位置大于结束位置说明已经没有需要处理的元素了，递归开始返回
		if(ps>pe)return null;

        // 取前序遍历的第一个数字，就是当前的根结点
		int value = preOrder[ps];
		
		int index = is;
		  // 在中序遍历的数组中找根结点的位置
		while(index<=ie&&inOrder[index]!=value)
			index++;

        // 创建当前的根结点，并且为结点赋值
		BinaryTree node = new BinaryTree();
		node.value = value;
		 // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
		node.left = construct(preOrder, ps+1, ps+index-is, inOrder, is, index-1);
		// 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
		node.right = construct(preOrder,ps+index-is+1 , pe, inOrder, index+1, ie);

        // 返回创建的根结点
		return node;
	}

	 
    // 中序遍历二叉树
    public static void printTree(BinaryTree root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
 
    }
    

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }


    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }
 

    public static void main(String[] args) {
 
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
    }

  

	
}
