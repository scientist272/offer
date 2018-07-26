package com.charlie.offer;
/*
 * 在一个二维数组中，每一行的数从左到右递增，
 * 每一列的数从上到下递增。输入这样的一个数组和一个整数，判断数组中是否含有该整数。

思路：别从左到右一个一个比，先比右上角的或左下角的，
如果要找的数比这个数小，剔除这一列，比较前一列的第一个数。如果大，剔除这一行，再比较该列下一个数。
注意如果先比左上角或右下角的是不行的
 */

public class MatrixSearch {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,},{4,5,6},{7,8,9}};
		int target = 4;
		System.out.println(find(target,matrix));
	}
	
    public static boolean find(int target,int[][] matrix){
    	int row = 0;
    	int col = matrix[0].length-1;
    	while(row<matrix.length&&col>=0){
    		if(matrix[row][col]==target){
    			return true;
    		}
    		else if(target>=matrix[row][col]){
    			row++;
    		}
    		else{
    			col--;
    		}
    	}
		return false;
    	
    }
}
