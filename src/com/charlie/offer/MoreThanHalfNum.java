package com.charlie.offer;
/*
��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ��������
����˵����

������һ������Ϊ9 ������� 1, 2, 3, 2, 2, 2, 5, 4, 2������������2�������г�����5 �Σ��������鳤�ȵ�һ�룬������2 ��

����˼·��

�ⷨһ������Partition ������O��n���㷨

��������һ�����ֳ��ֵĴ������������鳤�ȵ�һ�롣
������������������ô����֮��λ�������м������һ�������Ǹ����ִ����������鳤��һ������֡�
Ҳ����˵��������־���ͳ��ѧ�ϵ���λ����������Ϊn �������е�n/2 ������֡�

�����㷨���ܿ��������㷨����������������������㷨�У������������������ѡ��һ�����֣�Ȼ��������������ֵ�˳��
ʹ�ñ�ѡ�е�����С���ֶ�����������ߣ���ѡ�е����ִ�����ֶ����������ұߡ�������ѡ�е����ֵ��±�պ���n/2��
��ô������־����������λ������������±����n/2 ����ô��λ��Ӧ��λ��������ߣ����ǿ��Խ�����������߲��ֵ������в��ҡ�
��������±�С��n/2����ô��λ��Ӧ��λ�������ұߣ����ǿ��Խ����������ұ߲��ֵ������в��ҡ�����һ�����͵ĵݹ���̡�

�ⷨ���������������ص��ҳ�O(n)���㷨

��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬Ҳ����˵�����ֵĴ����������������ֳ��ִ����ĺͻ�Ҫ�ࡣ
������ǿ��Կ����ڱ��������ʱ�򱣴�����ֵ�� һ���������е�һ�����֣� һ���Ǵ����������Ǳ������¡������ֵ�ʱ��
�����һ�����ֺ�����֮ǰ�����������ͬ���������l �������һ�����ֺ�����֮ǰ��������֣���ͬ���������1 ��
�������Ϊù��������Ҫ������һ�����֣����Ѵ�����Ϊ1 ����������Ҫ�ҵ����ֳ��ֵĴ����������������ֳ��ֵĴ���֮�ͻ�Ҫ�࣬
��ôҪ�ҵ����ֿ϶������һ�ΰѴ�����Ϊ1 ʱ��Ӧ�����֡�

 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        moreThanHalfNum1(new int[]{1,8,5,2,2,2,2});
        moreThanHalfNum2(new int[]{1,8,5,2,2,2,2});

    }
    public static void moreThanHalfNum1(int[] array){
        if(array==null)
            return;
        int middleIndex = array.length/2;
        int left = 0;
        int right = array.length-1;
        int keyIndex = partition(array,left,right);
        while(keyIndex!=middleIndex){
            if(keyIndex>middleIndex){
                right = keyIndex-1;
                keyIndex = partition(array,left,right);
            }
            else{
                left = keyIndex+1;
                keyIndex = partition(array,left,right);
            }
        }
        if(check(array,array[keyIndex])){
            System.out.println(array[keyIndex]);
        }
        else{
            System.out.println("û�г���һ�����");
        }
    }

    public static void moreThanHalfNum2(int[] array){
        if(array==null){
            return;
        }
        int result = array[0];
        int count = 1;
        for (int i = 1; i <array.length ; i++) {
            if(count==0){
                result = array[i];
                count = 1;
            }
            else if(result==array[i]){
                count++;
            }
            else {
                count--;
            }
        }
        if(check(array,result)){
            System.out.println(result);
        }
        else{
            System.out.println("û�г���һ�����");
        }
    }


    public static int partition(int[] array,int left,int right){
        if(array==null)
            return -1;
        int key = array[left];
        int i = left;
        int j = right;
        while(i<j){
            while(i<j && array[j]>=key){
                j--;
            }
            array[i] = array[j];
            while(i<j&& array [i]<=key){
                i++;
            }
            array[j] = array[i];
        }
        array[i] = key;
        return i;
    }

    public static boolean check(int[] array,int number){
        int times = 0;
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==number){
                times++;
            }
        }
        if(times*2>array.length){
            result = true;
        }
        return result;
    }
}
