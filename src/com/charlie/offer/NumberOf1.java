package com.charlie.offer;

public class NumberOf1 {
    public static int easyImplements(int n){
        int number = 0;
        for (int i = 1; i <= n ; i++) {
            number += numOf1(i);
        }
        return number;
    }

    public static int numOf1(int n){
        int number = 0;
        while(n>0){
            if(n%10==1){
                number++;
            }
            n = n/10;
        }
        return number;
    }

    public static void main(String[] args) {
        int number = easyImplements(15);
        System.out.println(number);
    }
}
