package com.hc.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,59,77};
		print(srcArr);
		heapSort(srcArr);
	}
	
	public static void heapSort(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			foundHeap(arr, arr.length-1-i);
			swap(arr, 0, arr.length-1-i);
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	public static void foundHeap(int[] arr,int lastIndex){
		for (int i = (lastIndex-1)/2; i >= 0; i--) {
			int curNode =i;
			if ((curNode*2)+1 <= lastIndex) {
				int biggerIndex = curNode*2+1;
				if (biggerIndex < lastIndex) {
					if (arr[biggerIndex] < arr[biggerIndex+1]) {
						biggerIndex++;
					}
				}
				if (arr[curNode] < arr[biggerIndex]) {
					swap(arr, curNode, biggerIndex);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}

}
