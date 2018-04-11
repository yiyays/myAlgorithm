package com.hc.sort;

public class ShellSortRE {


	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,59,77};
		print(srcArr);
		int[] arr = shellSort(srcArr);
		print(arr);
	}
	
	public static int[] shellSort(int[] arr){
		double d1 = arr.length;
		while(true){
			d1 =Math.ceil(d1/2);
			int d = (int)d1;
			for (int i = 0; i < d; i++) {
				for (int j = i+d; j < arr.length; j+=d) {
					int temp = arr[j];
					int k = j-d;
					for (; k>= 0 && temp < arr[k]; k-=d) {
						arr[k+d] = arr[k];
					}
					arr[k+d] = temp;
				}
			}
			if(d == 1){
				break;
			}
		}
		return arr;
	}
	

	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}
	
}
