package com.charlie.offer;

public class Fibonacci {
    /*
    写一个函数，输入n，求斐波那契数列的第n项。斐波那契数列定义如下：n=0时,f(n)=0;n=1时,f(n)=1;n>1时,f(n)=f(n-1)+f(n-2)

思路1：先判断n<=0,return 0;然后判断n=1,return 1;否则return f(n-1)+f(n-2)。这种方法用了递归，简单好理解，但是效率差。

比如求f(10)，要先求f(9)和f(8)，以此类推，如果把f(10)作为二叉树的根节点，那么整个树的节点会有很多重复的，复杂度随n的增加而指数增加。

思路2：更简单的办法不是从n开始往下算，而是从0开始往上算，用循环而不是递归，即根据f(0)和f(1)算出f(2)，以此类推。复杂度为O(n)。

相关题：一只青蛙一次可以跳上1级台阶，也可以跳上2级，求该青蛙跳上一个n级的台阶共有、多少种跳法。


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
    问题二:一只青蛙一次可以跳上1级台阶，也可以跳上2 级……它也可以跳上n 级，此时该青蛙跳上一个n级的台阶总共有多少种跳法？

分析：当n=1，有1种跳法

      当n=2，一次跳一个跳两次，一次跳两个跳一次，共两种跳法

     当n>=2时，n个台阶，设有F（n）种跳法

     第一次选择跳1个，则剩下的n-1个有F(n-1)种跳法

     第一次选择跳2个，则剩下的n-2个有F(n-2)种跳法

       ....

     第一次选择跳n个，剩下n-n个台阶有F(n-n)

    F（0）=1；

F(n)=F(n-1)+F(n-2)+....+F(0)

F(n-1)=F(n-2)+F(n-3)+F(0)

两式相减得  F(n)=2*F(n-1)

  两种方法运行时间差不多
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
