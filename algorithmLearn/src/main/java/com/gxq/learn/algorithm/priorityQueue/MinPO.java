package com.gxq.learn.algorithm.priorityQueue;

public class MinPO {
	private int N = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void swin(int[] a, int k) {
		while (k > 1 && a[k / 2] > a[k]) {
			swap(a, k / 2, k);
			k = k / 2;
		}
	}
	
	
	private void sink(int[] a, int k) {
		while(2*k <= N) {
			int j = 2 * k;
			if(j < N && a[j] < a[j+1]) {
				j++;
			}
			
			if(a[k] <= a[j]) {
				break;
			}
			
			swap(a, a[k], a[j]);
			k = j;
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
