package com.hc.sort;


public class BubbleSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,77};
		print(srcArr);
		int[] arr = bubbleSort(srcArr);
		print(arr);
	}
	
	public static int[] bubbleSort(int[] srcArr){
		for(int i = 0; i < srcArr.length -1; i++){
			for(int j = 0;j < srcArr.length -1 -i;j++){
				 int temp = 0;
				 if (srcArr[j+1] < srcArr[j]) {
					temp = srcArr[j+1];
					srcArr[j+1] = srcArr[j];
					srcArr[j] = temp;
				}
			}
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
