package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class Insertion {

	public static void main(String[] args) {
		int[] arr = { 9, 5, 6, 7, 2, 3, 4, 8, 1 };
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sortBak(arr)));
	}

	public static void sort(int[] arr) {
		int len = arr.length, record = 1;
		for (int i = 1; i < len; i++) {
			int k = arr[i];
			int j = i - 1;
			while (j >= 0 && k < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = k;
			System.out.println("第" + record++ + "趟：" + Arrays.toString(arr));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static int[] sortBak(int[] arr) {
		int N = arr.length;
		for (int i = 1; i < N; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0  && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}

}
