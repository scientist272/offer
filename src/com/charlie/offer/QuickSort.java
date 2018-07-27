package com.charlie.offer;

import java.util.ArrayList;
import java.util.List;

//�������򷨣�����һ������key,����С�Ķ���������ߣ�������Ķ��������ұߡ��ٶ���ߺ��ұߵ�������ֱ���н��еݹ�
public class QuickSort {
    public static void quickSort(int array[],int left,int right){
        if (left>=right)
            return;
        int i = left;
        int j = right;
        int key = array[left];//�Ե�һ��Ԫ����Ϊ����key
        while (i<j) {
            while (i < j && key <= array[j]) {
                j--;
            }
            array[i] = array[j];//��keyС�ķ������
            while (i < j && key >= array[i]) {
                i++;
            }
            array[j] = array[i];//��key��ķ����ұ�
        }
        //����һ�ֺ�Ѳ���key��ԭ,����array[i]�Ƿֽ���,���������ߵݹ�
            array[i] = key;
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <50 ; i++) {
            int temp = (int) (Math.random()*10);
            if (!list.contains(temp)) {
                list.add(temp);
            }
        }
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }//����һ������Ϊ50�����������
        for (int i = 0; i <values.length ; i++) {
            System.out.print(values[i]+",");
        }
        System.out.println();
        quickSort(values,0,values.length-1);
        for (int i = 0; i <values.length ; i++) {
            System.out.print(values[i]+",");
        }
    }
}
