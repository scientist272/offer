package com.charlie.offer;

/*
���⣺����һ���ַ�������ӡ���ַ������ַ����������У���������abc�����abc��acb��bac��bca��cab��cba��

˼·����һ���ַ��������������֣���һ���������ĵ�һ���ַ����ڶ�����������ߵ������ַ���
���������еĹ��̿ɿ�����������һ�������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ��ͺ���������ַ�������
�ڶ����̶���һ���ַ�������������ַ������У���ʱ�԰Ѻ��������ַ��ֳ������������֣�Ȼ��ݹ鴦��


 */
public class Permutation {
    public static void permutation(char[] str) {
        if (str == null) {
            return;
        }
        permutation(str, 0);
    }

    public static void permutation(char[] str, int begin) {
        if (begin == str.length - 1) {
            System.out.print(new String(str) + " ");
        } else {
            for (int i = begin; i < str.length; i++) {

                //1,���ܳ����ڵ�һ��λ�õ��ַ�����������һ���ַ��ͺ�������ַ�����һ�����Լ����Լ�����
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;

                //2,�̶���һ���ַ����ݹ�����������ַ�������
                permutation(str, begin + 1);

                //3,�ݹ鴦�����ߵ��ַ��󣬼ǵð�ǰ�߽������ַ��ٻ���������֤��һ��λ�õ��ַ����ظ�
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};

        permutation(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};

        permutation(c2);
    }
}
