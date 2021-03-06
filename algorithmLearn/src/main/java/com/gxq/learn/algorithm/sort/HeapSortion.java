package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class HeapSortion {

	public static void main(String[] args) {
		//int[] arr = { 3, 8, 9, 6, 5, 4, 7, 2, 1 };
		int[] arr = { 1, 3, 5, 6, 2, 9, 7, 4 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void sort(int[] a) {
		int size = a.length;
		buildHeap(a, size);
		for (int i = size - 1; i > 0; i--) {// i为无序区的长度，经过如下两步，长度递减
			swap(a, 0, i);// 1.每次将堆顶元素和无序区最后一个元素交换，即将无序区最大的元素放入有序区
			adjustHeap(a, 0, i);// 2.将无顺区调整为大顶堆，即选择出最大的元素
		}
	}

	private static void buildHeap(int[] a, int size) {
		for (int i = size / 2; i >= 0; i--) {
			adjustHeap(a, i, size);
		}
	}

	private static void adjustHeap(int[] a, int i, int size) {
		System.out.println("a[i]="+a[i]+"  i="+i);
		int lc = 2 * i + 1;
		int rc = 2 * i + 2;
		int max = i;
		if (i < size / 2) {
			System.out.println(Arrays.toString(a));
			if (lc < size && a[max] < a[lc]) {
				max = lc;
			}
			if (rc < size && a[max] < a[rc]) {
				max = rc;
			}
			if (i != max) {
				swap(a, i, max);
				adjustHeap(a, max, size);
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
