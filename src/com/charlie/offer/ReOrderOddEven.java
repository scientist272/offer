package com.charlie.offer;
/*
��Ŀ:����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
˼·�������ĿҪ����������������ǰ�벿�֣� ż����������ĺ�벿�֣�������е�����Ӧ��λ��ż����ǰ�档Ҳ����˵������ɨ����������ʱ�� ���������ż��������������ǰ�棬���ǿ��Խ������ǵ�˳�򣬽���֮��ͷ���Ҫ���ˡ�

������ǿ���ά������ָ�룬��һ��ָ���ʼ��ʱָ������ĵ�һ�����֣���ֻ����ƶ���
�ڶ���ָ���ʼ��ʱָ����������һ�����֣� ��ֻ��ǰ�ƶ���������ָ������֮ǰ����һ��ָ������λ�ڵڶ���ָ���ǰ�档
�����һ��ָ��ָ���������ż�������ҵڶ���ָ��ָ������������������Ǿͽ������������֡�
 */
public class ReOrderOddEven {
    public static void reOrderOddEven(int[] array){
        if(array.length<2||array == null){
            return;
        }

        int start = 0;
        int end = array.length-1;
        int temp = 0;
        while(start < end ){
            //��ż��
            while(start < end && array[start] % 2 != 0){
                start++;
            }
            //������
            while(start < end && array[end] % 2 ==0){
                end--;
            }
            temp = array[end];
            array[end] = array[start];
            array[start]= temp;
        }
    }

    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderOddEven(array);
        printArray(array);
    }
}
