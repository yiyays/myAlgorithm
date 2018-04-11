package com.hc.sort;


public class ShellSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,77};
		print(srcArr);
		int[] arr = shellSort(srcArr);
		print(arr);
	}
	
	
	public static int[] shellSort(int[] srcArr){
		double d1 = srcArr.length;
		while (true) {
			d1 = Math.ceil(d1/2);
			int d = (int) d1;
			for (int i = 0; i < d; i++) {
				for (int j = i+d; j < srcArr.length; j+=d) {
					int temp = srcArr[j];
					int k = j-d;
					for (; k >= 0 && temp < srcArr[k]; k-=d) {
						srcArr[k+d] = srcArr[k];
					}
					srcArr[k+d] = temp;
				}
			}
			if (d == 1) {
				break;
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
