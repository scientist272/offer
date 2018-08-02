package com.charlie.offer;

public class NumOf2 {
    /*
    ʵ��һ������������һ��������������������Ʊ�ʾ��1�ĸ���������9�Ķ�������1001�������2��
    ˼·����һ��������ȥ1֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱�ڰ����������Ʊ�ʾ�е����ұ�һ��1���0��
    ��������������һ�������Ķ����Ʊ�ʾ���ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ�����
     */
    public static int numOf2(int n){
        int result = 0;
        while(n!=0){
            n = n&(n-1);
            result++;
        }
        return result;
    }
    /*
     �����Ŀ3������ת�����⣬��Excel2003�У���A��ʾ��һ�У�B��ʾ�ڶ���...Z��ʾ��26�У�AA��ʾ��27�У�AB��ʾ��28��...�������ơ�
    ��д��һ����������������ĸ��ʾ���кű��룬������ǵڼ��С�

     �����Ŀ4�����������������������26���Ʊ�ʾ�أ�
     */
    public static int excel3(String string){
        char[] str = string.toCharArray();
        int result = 0;
        int excp = 0;
        for (int i = str.length-1; i >=0 ; i--) {
            result += (int) ((str[i]-'A'+1)*Math.pow(26,excp));
            excp++;
        }
        return result;
    }

    public static String excel4(int n){
        StringBuilder builder = new StringBuilder();
        while(n!=0){
            int temp = n%26;//���һλ
            n = n/26;//�����ڶ�λ
            if(temp ==0){
                temp = 26;
                n = n-1;
            }
            builder.append((char) ('A'+temp-1));//�����Ƿ��򣬺����ٷ�ת

        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(numOf2(10));
        System.out.println(excel3("AA"));
        System.out.println(excel4(52));
    }
}
