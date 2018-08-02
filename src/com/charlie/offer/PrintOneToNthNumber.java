package com.charlie.offer;
/*
  ���⣺��������n,��˳���ӡ����1������nλʮ����������������n=3�����ӡ��1��2��3...999
  ˼·����һ������Ϊn����������ӡ�������ÿһλ���Ǵ�0��9��ȫ���У��õݹ�ʵ��
 */
public class PrintOneToNthNumber {
    public static void printOneToNthNumber(int n,int[] array){
        if(n>=array.length){
            printArray(array);
        }
        else{
            for (int i = 0; i <=9 ; i++) {
                array[n] = i;
                printOneToNthNumber(n+1,array);
            }
        }
    }

    public static void printArray(int[] array){
        int index = 0;

        //�������е�һ����0��Ԫ�ؿ�ʼ��ӡ
        while (index<array.length&&array[index] == 0){
            index++;
        }

        for (int i = index; i < array.length; i++) {
            System.out.print(array[i]);
        }

        //�������з���Ԫ�أ������Ա��ʾ��һ��nλ��
        if(index<array.length){
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[2];
        printOneToNthNumber(0,array);
    }
}
