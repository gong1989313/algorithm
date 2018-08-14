package com.gxq.learn.algorithm.sort;

import java.util.Arrays;

public class MergeSortion {
    /** 
     * 归并排序 
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，
     *     每个子序列是有序的。然后再把有序子序列合并为整体有序序列 
     * 相邻有序子序列进行合并
	 * a[low...mid] a[mid+1,high]
     * 时间复杂度为O(nlogn) 
     * 稳定排序方式 
     * @param nums 待排序数组 
     * @return 输出有序数组 
     */
	private static void merge(int a[], int temp[], int low, int mid, int high) {
		int i = low;//左序列指针
		int j = mid + 1;//右序列指针
		int k = 0;//临时数组指针
		// 找出较小值元素放入temp数组中
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		//将左边剩余元素填充进temp中
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		//将右序列剩余元素填充进temp中
		while (j <= high) {
			temp[k++] = a[j++];
		}
		k = 0;
		// 将temp中的元素全部拷贝到原数组中
		while (low <= high) {
			a[low++] = temp[k++];
		}
	}

	public static void sort(int a[], int temp[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(a, temp, low, mid);//左边归并排序，使得左子序列有序
			sort(a, temp, mid + 1, high);//右边归并排序，使得右子序列有序
			merge(a, temp, low, mid, high);//将两个有序子数组合并操作
		}
	}

	public static void sort(int[] arr) {
		// 定义一个辅助数组，所以该算法的空间复杂度为O（n）
		// 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		int[] temp = new int[arr.length];
		sort(arr, temp, 0, arr.length - 1);
	}

	public static void main(String[] args) {
	      int arr[]= {9,8,7,6,5,4,3,2,1};
	      System.out.println("排序前："+Arrays.toString(arr));
	      sort(arr);
	      System.out.println("排序结果："+Arrays.toString(arr));
	}

}
