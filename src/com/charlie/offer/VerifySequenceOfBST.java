package com.charlie.offer;
/*
��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
������򷵻�true�����򷵻�false���������������������������ֶ�������ͬ��

����˼·��
�ں�������õ��������У� ���һ�����������ĸ�����ֵ��������ǰ������ֿ��Է�Ϊ�����֣� ��һ����������������ֵ�����Ƕ��ȸ�����ֵС��
�ڶ�����������������ֵ�����Ƕ��ȸ�����ֵ��
 */
public class VerifySequenceOfBST {
    public static boolean verifySequenceOfBST(int[] array){
        return verifySequenceOfBST(array,0,array.length-1);
    }
    public static boolean verifySequenceOfBST(int[] array,int start,int end){
        // �����ӦҪ���������ֻ��һ�������Ѿ�û������Ҫ����start>end���ͷ���true
        if(start>=end){
            return true;
        }

        if(array.length==0||array==null){
            return  false;
        }

        int index = start;
        //Ѱ�����������ڵ�
        while(index<end-1 && array[index]<array[end]){
            index++;
        }
        //��¼���������ڵ��λ��
        int right = index;
        //������������ܱ���������򲻷��϶���������Ҫ��
        while(index<end-1 && array[index]>array[end]){
            index ++;
        }
        //������������ܱ���������򲻷��϶���������Ҫ��
        if(index != end-1){
            return false;
        }
        //���������ڵ���Ϊ�ݹ�ķֽ���
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

        // ����ֻ��1�����
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }
}
