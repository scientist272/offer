package com.charlie.offer;

import java.util.ArrayList;
import java.util.List;

//快速排序法：先找一个参照key,比它小的都放在它左边，比它大的都放在它右边。再对左边和右边的子数组分别进行进行递归
public class QuickSort {
    public static void quickSort(int array[],int left,int right){
        if (left>=right)
            return;
        int i = left;
        int j = right;
        int key = array[left];//以第一个元素作为参照key
        while (i<j) {
            while (i < j && key <= array[j]) {
                j--;
            }
            array[i] = array[j];//比key小的放在左边
            while (i < j && key >= array[i]) {
                i++;
            }
            array[j] = array[i];//比key大的放在右边
        }
        //排完一轮后把参照key还原,现在array[i]是分界线,对左右两边递归
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
        }//生成一个长度为50的随机数数组
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
