package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class Insertion {

	public static void main(String[] args) {
		int[] arr = {9,5,6,7,2,3,4,8,1}; 
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sort(arr)));
	}
	
	public static int[] sort(int[] arr) {
		int len = arr.length;
		for(int i=1; i<len;i++) {
			int k = arr[i];
			int j = i-1;
			while(j>=0 && k < arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=k;
		}
		return arr;
	}
}
