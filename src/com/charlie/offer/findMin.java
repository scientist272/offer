package com.charlie.offer;

/*
 * 
把一个数组最开始的几个元素搬到数组末尾，我们称之为数组的旋转，输入一个递增的数组的旋转，输出它的最小元素。如{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，输出1。

 思路：直观想法是从头到尾遍历就行，复杂度O(n)，
 但是这个数组其实已经划分为两个排好序的子数组，
 前面一个子数组的元素都大于等于后边一个，并以最小元素为分界。

 对于排好序的数组，推荐用二分查找复杂度为O(logn)，
 做法是一个指针指首元素，一个指针指尾元素，若中间元素大于等于首元素，
 则它位于前一个子数组内，最小元素在中间元素之后。反之同理。
 */
public class findMin {
	public static int findMin(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1; // 如果中间的大于最后的，说明最小的后面一半的子数组中
			} else if (array[mid] == array[high]) {
				high = high - 1;
			} else {
				high = mid; // 如果中间的小于最后的，说明最小的前面一半的子数组中
			}
		}

		return array[low];

	}

	public static void main(String[] args) {
		int[] array = { 3, 4, 5, 1, 2 };
		System.out.println(findMin(array));
	}
}
