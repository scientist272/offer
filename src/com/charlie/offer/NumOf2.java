package com.charlie.offer;

public class NumOf2 {
    /*
    实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如9的二进制是1001，则输出2。
    思路：把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把整数二进制表示中的最右边一个1变成0。
    基于上述做法，一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
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
     相关题目3：进制转换问题，在Excel2003中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。
    请写出一个函数，输入用字母表示的列号编码，输出它是第几列。

     相关题目4：如果反过来输入列数，求26进制表示呢？
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
            int temp = n%26;//最后一位
            n = n/26;//倒数第二位
            if(temp ==0){
                temp = 26;
                n = n-1;
            }
            builder.append((char) ('A'+temp-1));//这里是反序，后面再反转

        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(numOf2(10));
        System.out.println(excel3("AA"));
        System.out.println(excel4(52));
    }
}
