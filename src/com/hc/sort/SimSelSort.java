package com.hc.sort;

public class SimSelSort {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,77};
		print(srcArr);
		int[] arr = simSelSort(srcArr);
		print(arr);
	}
	
	public static int[] simSelSort(int[] srcArr){
		for(int i = 0; i < srcArr.length -1;i++){
			int tempMax = srcArr[i];
			int tempMaxIndex = i;
			for (int j = i+1; j < srcArr.length; j++) {
				if (tempMax > srcArr[j]) {
					tempMax = srcArr[j];
					tempMaxIndex = j;
				}
			}
			srcArr[tempMaxIndex] = srcArr[i];
			srcArr[i] = tempMax;
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
