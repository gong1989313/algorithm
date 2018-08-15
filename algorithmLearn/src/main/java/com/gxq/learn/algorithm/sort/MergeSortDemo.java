package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class MergeSortDemo {
	private static void sort(int[] arr) {
		int N = arr.length;
		int[] temp = new int[N];
		sort(arr, temp, 0, N - 1);
	}

	private static void sort(int[] arr, int[] temp, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(arr, temp, low, mid);
			sort(arr, temp, mid + 1, high);
			merge(arr, temp, low, mid, high);
		}
	}

	private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= high) {
			temp[k++] = arr[j++];
		}
		
		k = 0;
		while(low<=high) {
			arr[low++] = temp[k++];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 32, 24, 95, 45, 75, 22, 95, 49, 3, 76, 56, 11, 37, 58, 44, 19, 81 };
		// int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("排序前：" + Arrays.toString(arr));
		sort(arr);
		System.out.println("排序后：" + Arrays.toString(arr));

	}

}
