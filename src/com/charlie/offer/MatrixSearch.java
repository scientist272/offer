package com.charlie.offer;
/*
 * ��һ����ά�����У�ÿһ�е��������ҵ�����
 * ÿһ�е������ϵ��µ���������������һ�������һ���������ж��������Ƿ��и�������

˼·���������һ��һ���ȣ��ȱ����ϽǵĻ����½ǵģ�
���Ҫ�ҵ����������С���޳���һ�У��Ƚ�ǰһ�еĵ�һ������������޳���һ�У��ٱȽϸ�����һ������
ע������ȱ����Ͻǻ����½ǵ��ǲ��е�
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
