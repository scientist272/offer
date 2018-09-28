package com.charlie.offer;

/*
问题：输入一个字符串，打印出字符串中字符的所有排列，例如输入abc，输出abc，acb，bac，bca，cab，cba。

思路：把一个字符串看成两个部分，第一部分是它的第一个字符，第二部分是它后边的所有字符。
求所有排列的过程可看做两步，第一步求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换。
第二步固定第一个字符，求后面所有字符的排列，此时仍把后面所有字符分成上述的两部分，然后递归处理。


 */
public class Permutation {
    public static void permutation(char[] str) {
        if (str == null) {
            return;
        }
        permutation(str, 0);
    }

    public static void permutation(char[] str, int begin) {
        if (begin == str.length - 1) {
            System.out.print(new String(str) + " ");
        } else {
            for (int i = begin; i < str.length; i++) {

                //1,可能出现在第一个位置的字符，即交换第一个字符和后边所有字符，第一次是自己和自己交换
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;

                //2,固定第一个字符，递归求后面所有字符的排列
                permutation(str, begin + 1);

                //3,递归处理完后边的字符后，记得把前边交换的字符再换回来，保证第一个位置的字符不重复
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};

        permutation(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};

        permutation(c2);
    }
}
