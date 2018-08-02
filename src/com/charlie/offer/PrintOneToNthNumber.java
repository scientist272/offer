package com.charlie.offer;
/*
  问题：输入数字n,按顺序打印出从1到最大的n位十进制数。比如输入n=3，则打印出1、2、3...999
  思路：用一个长度为n的数组来打印，数组的每一位都是从0到9的全排列，用递归实现
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

        //从数组中第一个非0的元素开始打印
        while (index<array.length&&array[index] == 0){
            index++;
        }

        for (int i = index; i < array.length; i++) {
            System.out.print(array[i]);
        }

        //数组中有非零元素，换行以便表示下一个n位数
        if(index<array.length){
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[2];
        printOneToNthNumber(0,array);
    }
}
