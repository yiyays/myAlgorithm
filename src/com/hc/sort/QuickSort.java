package com.hc.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,77};
		print(srcArr);
		sort(srcArr);
		print(srcArr);
		
	}
	public static void sort(int[] arr){
		if (arr.length>0) {
			quickSort(arr, 0, arr.length-1);
		}
		
	}
	
	public static void quickSort(int[] arr,int low,int high){
		if (low < high) {
			int standardIndex = getStandardIndex(arr, low, high);	//将选定的基准值排入正确位置，并返回索引，用作分界进行左右递归；
			quickSort(arr, low, standardIndex-1);
			quickSort(arr, standardIndex+1, high);
		}
	}
	
	public static int getStandardIndex(int[] arr,int low ,int high){
		int standard = arr[low];
		while (low < high) {
			while (low < high && standard <= arr[high]) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && standard >= arr[low]) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = standard;
		return low;
	}

	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}


}
