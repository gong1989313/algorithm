package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class QuickSortion {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		startSort(arr, 0, arr.length - 1);
		System.out.println("排序结果：" + Arrays.toString(arr));
	}

	public static void startSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		medianOfThree(arr, low, high);
		int partition = Partition(arr, low, high);// 以第一个元素为基准元素，大于基准元素的在右边
		// 小于基准元素的在左边
		startSort(arr, low, partition - 1);
		startSort(arr, partition + 1, high);
	}

	/*
	 * 将数组分成两块，返回基准元素在数组中的位置
	 * @param arr 待排序数组
	 * @param low,high 规定数组中的待排序数据块位置
	 */
	public static int Partition(int[] data, int low, int high) {
		int begin = low;
		int end = high;
		int key = data[low];// 取该数组块的第一个元素作为基准元素
		while (begin < end) {
			while (begin < end && data[end] >= key) {
				end--;
			}
			data[begin] = data[end];// 第一步
			while (begin < end && data[begin] <= key) {
				begin++;
			}
			display(data);
			System.out.println();
			data[end] = data[begin];// 第二步
		}
		data[begin] = key;// 基准元素居中，第三步
		return begin;
	}

	public static void display(int[] data) {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + ",");
	}

	/*
	 * 交换两个元素
	 */
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/*
	 * 三数取中
	 */
	public static void medianOfThree(int[] data, int begin, int end) {
		int mid = (end - begin) / 2 + begin;
		if (data[mid] > data[end]) {
			swap(data, mid, end);
		}
		if (data[begin] > data[end]) {
			swap(data, begin, end);
		}
		if (data[mid] > data[begin]) {
			swap(data, mid, begin);
		}
	}
}
