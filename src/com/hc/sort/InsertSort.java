package com.hc.sort;

public class InsertSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,59,54,22,77};
		print(srcArr);
		int[] arr = insertSort(srcArr);
		print(arr);
	}
	
	public static int[] insertSort(int[] srcArr){
		for (int i = 1; i < srcArr.length; i++) {
			int j = i-1;
			int temp = srcArr[i];
			for (; j >= 0 && temp < srcArr[j]; j--) {
				srcArr[j+1] = srcArr[j];
			}
			srcArr[j+1] = temp;
		}
		return srcArr;
	} 
	
	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}
}
