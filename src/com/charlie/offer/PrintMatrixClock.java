package com.charlie.offer;

public class PrintMatrixClock {
    /*
    ��Ŀ������һ�����󣬰��մ���������˳ʱ���˳������ɨӡ��ÿһ������
    �Ѵ�ӡһȦ��Ϊ�Ĳ�����һ�������Ҵ�ӡһ�У��ڶ������ϵ��´�ӡһ�У�
    ���������ҵ����ӡһ�У����Ĳ����µ��ϴ�ӡһ�С�
    ÿһ�����Ǹ�����ʼ�������ֹ������һ��ѭ�����ܴ�ӡ��һ�л���һ�С�
    */
    public static void printMatrixClockWisely(int[][] array){
        if(array == null){
           return ;
        }
        //srow,scolΪÿһȦ����ʼ�кź���ʼ�к�
        int srow = 0;
        int scol = 0;

        //ѭ��һȦһȦ��ӡ������Ϊ��ʼ�кź���ʼ�кų�2��С�ھ����������
        while(srow*2 < array.length && scol*2 <array[0].length){
            printMatrixClockInCircle(array,srow,scol);
            srow++;
            scol++;
        }
    }

    public static void printMatrixClockInCircle(int[][] array,int srow, int scol){
        int rows = array.length;
        int cols = array[0].length;
        //cols - col -1 Ϊ��ӡһȦ����ֹ�к�
        //rows - row -1 Ϊ��ӡһȦ����ֹ�к�

        //��һ��������ζ���ִ��
        for (int i = scol; i <= cols-scol-1; i++) {
            System.out.print(array[srow][i]+" ");
        }

        //�ڶ���ִ�е�����Ϊ��ֹ�кŴ�����ʼ�к�
        if(rows-srow-1>srow){
            for (int i = srow+1; i <= rows-srow-1 ; i++) {
                System.out.print(array[i][cols-scol-1]+" ");
            }
        }

        //������ִ�е�����Ϊ��ֹ�кŴ�����ʼ�к�����ֹ�кŴ�����ʼ�к�
        if(rows-srow-1>srow && cols-scol-1>scol){
            for (int i = cols-scol-2; i >=scol ; i--) {
                System.out.print(array[rows-srow-1][i]+" ");
            }
        }

        //���Ĳ�ִ�е�����Ϊ��ֹ�кű���ʼ�кŴ�2����ֹ�кŴ�����ʼ�к�
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
