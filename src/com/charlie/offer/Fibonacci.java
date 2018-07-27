package com.charlie.offer;

public class Fibonacci {
    /*
    дһ������������n����쳲��������еĵ�n�쳲��������ж������£�n=0ʱ,f(n)=0;n=1ʱ,f(n)=1;n>1ʱ,f(n)=f(n-1)+f(n-2)

˼·1�����ж�n<=0,return 0;Ȼ���ж�n=1,return 1;����return f(n-1)+f(n-2)�����ַ������˵ݹ飬�򵥺���⣬����Ч�ʲ

������f(10)��Ҫ����f(9)��f(8)���Դ����ƣ������f(10)��Ϊ�������ĸ��ڵ㣬��ô�������Ľڵ���кܶ��ظ��ģ����Ӷ���n�����Ӷ�ָ�����ӡ�

˼·2�����򵥵İ취���Ǵ�n��ʼ�����㣬���Ǵ�0��ʼ�����㣬��ѭ�������ǵݹ飬������f(0)��f(1)���f(2)���Դ����ơ����Ӷ�ΪO(n)��

����⣺һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨�׹��С�������������


     */
    public static int fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int fibOne = 0; //f(0)
        int fibTwo = 1;//f(1)
        int fibN = 0; //f(n)

        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }
    /*
    �����:һֻ����һ�ο�������1��̨�ף�Ҳ��������2 ��������Ҳ��������n ������ʱ����������һ��n����̨���ܹ��ж�����������

��������n=1����1������

      ��n=2��һ����һ�������Σ�һ����������һ�Σ�����������

     ��n>=2ʱ��n��̨�ף�����F��n��������

     ��һ��ѡ����1������ʣ�µ�n-1����F(n-1)������

     ��һ��ѡ����2������ʣ�µ�n-2����F(n-2)������

       ....

     ��һ��ѡ����n����ʣ��n-n��̨����F(n-n)

    F��0��=1��

F(n)=F(n-1)+F(n-2)+....+F(0)

F(n-1)=F(n-2)+F(n-3)+F(0)

��ʽ�����  F(n)=2*F(n-1)

  ���ַ�������ʱ����
     */
   public static int frogsJump(int n ){
       if(n==1||n==2){
           return n;
       }
       int result = 0;
       int first = 1;

       for (int i = 2; i <= n ; i++) {
           result = 2*first;
           first = result;
       }
       return result;
   }
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(frogsJump(7));
    }


}
