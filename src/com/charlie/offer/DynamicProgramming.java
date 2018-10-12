package com.charlie.offer;
/*
钢条切割问题
钢条切割问题：出售一段长度为i英寸的钢条的价格为Pi：

长度i    1    2    3    4     5      6      7      8      9     10

价格pi  1    5    8    9    10    17    17    20    24    30
 */
public class DynamicProgramming {
    public static int cutIron(int[] p){
        int[] r = new int[p.length+1];
        for (int i = 1; i <=p.length ; i++) {
            int q = -1;
            for(int j=1;j<=i;j++){
                q = Math.max(q,p[j-1]+r[i-j]);
            }
            r[i] = q;
        }


        return r[p.length];
    }

    public static void main(String[] args) {
        int[] p = new int[]{1,5,8,9};
        int maxBenefit = cutIron(p);
        System.out.println(maxBenefit);
    }
}
