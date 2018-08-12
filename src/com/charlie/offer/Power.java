package com.charlie.offer;

public class Power {
    /*
    ʵ�ֺ���double Power(double base,long exponent)����base��exponent�η�������ʹ�ÿ⺯�������ÿ��Ǵ������⡣

    ע�⣺�ж�����С���Ƿ���Ȳ�����==����Ϊ�������ʾС����������ֻ���ж����ǲ�ľ���ֵ�Ƿ���һ����С�ķ�Χ�ڡ�
     */
    public static double power(double base, long exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");

        }

        long exp = exponent;

        //ָ���ľ���ֵ�������
        if (exponent < 0) {
            exp = -exp;
        }

        double result = powerWithUnsigned(base, exp);

        //ָ��С��0�������ɵ���
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

        double result = power(base, exponent >> 1); //����һλ�����2��Ч�ʸ���
        result *= result;

        //���exponentΪ���������ٳ�һ��base
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
