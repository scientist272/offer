package com.charlie.offer;

public class PrintMatrixClock {
    /*
    题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
    把打印一圈分为四步：第一步从左到右打印一行，第二步从上到下打印一列，
    第三步从右到左打印一行，第四步从下到上打印一列。
    每一步我们根据起始坐标和终止坐标用一个循环就能打印出一行或者一列。
    */
    public static void printMatrixClockWisely(int[][] array){
        if(array == null){
           return ;
        }
        //srow,scol为每一圈的起始行号和起始列号
        int srow = 0;
        int scol = 0;

        //循环一圈一圈打印的条件为起始行号和起始列号乘2都小于矩阵的行列数
        while(srow*2 < array.length && scol*2 <array[0].length){
            printMatrixClockInCircle(array,srow,scol);
            srow++;
            scol++;
        }
    }

    public static void printMatrixClockInCircle(int[][] array,int srow, int scol){
        int rows = array.length;
        int cols = array[0].length;
        //cols - col -1 为打印一圈的终止列号
        //rows - row -1 为打印一圈的终止行号

        //第一步无论如何都会执行
        for (int i = scol; i <= cols-scol-1; i++) {
            System.out.print(array[srow][i]+" ");
        }

        //第二步执行的条件为终止行号大于起始行号
        if(rows-srow-1>srow){
            for (int i = srow+1; i <= rows-srow-1 ; i++) {
                System.out.print(array[i][cols-scol-1]+" ");
            }
        }

        //第三步执行的条件为终止行号大于起始行号且终止列号大于起始列号
        if(rows-srow-1>srow && cols-scol-1>scol){
            for (int i = cols-scol-2; i >=scol ; i--) {
                System.out.print(array[rows-srow-1][i]+" ");
            }
        }

        //第四步执行的条件为终止列号比起始列号大2且终止列号大于起始列号
        if(rows-srow-1>srow+1 && cols-scol-1>scol){
            for (int i = rows-srow-2; i > srow ; i--) {
                System.out.print(array[i][scol]+" ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] a={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printMatrixClockWisely(a);
    }
}
