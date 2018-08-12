package com.charlie.offer;

public class Power {
    /*
    实现函数double Power(double base,long exponent)，求base的exponent次方，不得使用库函数，不用考虑大数问题。

    注意：判断两个小数是否相等不能用==，因为计算机表示小数有误差，我们只能判断它们差的绝对值是否在一个很小的范围内。
     */
    public static double power(double base, long exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");

        }

        long exp = exponent;

        //指数的绝对值传入计算
        if (exponent < 0) {
            exp = -exp;
        }

        double result = powerWithUnsigned(base, exp);

        //指数小于0，结果变成倒数
        if (exponent < 0) {
            result = 1 / result;
        }

        return result;

    }

    public static double powerWithUnsigned(double base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = power(base, exponent >> 1); //右移一位代替除2，效率更高
        result *= result;

        //如果exponent为奇数，则再乘一个base
        if (exponent % 2 != 0) {
            result *= base;
        }
        return result;
    }

    private static boolean equal(double num1, double num2) {
        if (((num1 - num2) > -0.0000001) && (num1 - num2) < 0.0000001) {
            return true;
        } else return false;
    }


    public static void main(String[] args) {
        System.out.println(power(5, 3));
    }
}
