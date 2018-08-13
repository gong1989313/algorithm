package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class ShellSortion {

	public static void main(String[] args) {
		int arr[] = { 32, 24, 95, 45, 75, 22, 95, 49, 3, 76, 56, 11, 37, 58, 44, 19, 81 };
		System.out.println("排序前：" + Arrays.toString(arr));
		// sort(arr);
		sortBak(arr);
		System.out.println("排序后：" + Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		int N = arr.length;
		int d = N / 2;
		int key, j, record = 1;
		while (d >= 1) {
			for (int i = d; i < N; i++) {
				key = arr[i];
				j = i - d;
				while (j >= 0 && arr[j] > key) {
					arr[j + d] = arr[j];
					j = j - d;
				}
				arr[j + d] = key;
			}
			d = d / 2;
			System.out.println("第" + record++ + "趟：" + Arrays.toString(arr));
		}
	}

	private static void sortBak(int[] arr) {
		int N = arr.length;
		int d = N / 2;
		while (d >= 1) {
			for (int i = d; i < N; i++) {
				int key = arr[i];
				int j = i - d;
				while (j >= 0 && key < arr[j]) {
					arr[j + d] = arr[j];
					j = j - d;
				}
				arr[j + d] = key;
			}
			d = d / 2;
		}
	}
}