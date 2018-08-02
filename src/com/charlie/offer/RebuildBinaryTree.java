package com.charlie.offer;

public class RebuildBinaryTree {
	 /**
	  * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ����ö�������
	  * ���������ǰ���������������Ľ���ж������ظ������֡�
	  * ���磺ǰ��������У� 1, 2, 4, 7, 3, 5, 6, 8��
	  * ������������У�4, 7, 2, 1, 5, 3, 8��6}���ؽ�����ͼ��ʾ�Ķ��������������ͷ��㡣
     * �������ڵ���
     */
	public static class BinaryTree{
		int value;
		BinaryTree left;
		BinaryTree right;
	}
	

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preOrder ǰ�����
     * @param inOrder  �������
     * @return ���ĸ����
     */
  
	public static BinaryTree construct(int[] preOrder,int[] inOrder){

		return construct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     *
     * @param preOrder ǰ�����
     * @param ps       ǰ������Ŀ�ʼλ��
     * @param pe       ǰ������Ľ���λ��
     * @param inOrder  �������
     * @param is       ��������Ŀ�ʼλ��
     * @param ie       ��������Ľ���λ��
     * @return ���ĸ����
     */
    
	private static BinaryTree construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
		 // ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ���ˣ��ݹ鿪ʼ����
		if(ps>pe)return null;

        // ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ����
		int value = preOrder[ps];
		
		int index = is;
		  // ������������������Ҹ�����λ��
		while(index<=ie&&inOrder[index]!=value)
			index++;

        // ������ǰ�ĸ���㣬����Ϊ��㸳ֵ
		BinaryTree node = new BinaryTree();
		node.value = value;
		 // �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-is+1��
        // ��������Ӧ��ǰ�������λ����[ps+1, ps+index-is]
        // ��������Ӧ�����������λ����[is, index-1]
		node.left = construct(preOrder, ps+1, ps+index-is, inOrder, is, index-1);
		// �ݹ鹹����ǰ����������������������Ԫ�ظ�����ie-index��
        // ��������Ӧ��ǰ�������λ����[ps+index-is+1, pe]
        // ��������Ӧ�����������λ����[index+1, ie]
		node.right = construct(preOrder,ps+index-is+1 , pe, inOrder, index+1, ie);

        // ���ش����ĸ����
		return node;
	}

	 
    // �������������
    public static void printTree(BinaryTree root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
 
    }
    

    // ��ͨ������
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

    // ���н�㶼û�����ӽ��
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

    // ���н�㶼û�����ӽ��
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

    // ����ֻ��һ�����
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTree root = construct(preorder, inorder);
        printTree(root);
    }


    // ��ȫ������
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
