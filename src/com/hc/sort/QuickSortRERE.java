package com.hc.sort;

public class QuickSortRERE {

	public static void main(String[] args) {
		int[] srcArr ={57,59,52,77,79,29,65,54,22,39,65,54,};
		print(srcArr);
		sort(srcArr);
		print(srcArr);

	}
	
	private static void sort(int[] srcArr) {
		if (srcArr.length>0) {
			quickSort(srcArr,0,srcArr.length-1);
		}
	}

	private static void quickSort(int[] srcArr, int low, int high) {
		if(low < high){
			int standardIndex = getStandardIndex(srcArr,low,high);
			quickSort(srcArr, low, standardIndex-1);
			quickSort(srcArr, standardIndex+1, high);
		}
	}

	private static int getStandardIndex(int[] srcArr, int low, int high) {
		int standard = srcArr[low];
		while (low < high) {
			while (low < high && standard <= srcArr[high]) {
				high--;
			}
			srcArr[low] = srcArr[high];
			while (low < high && standard >= srcArr[low]) {
				low++;
			}
			srcArr[high] = srcArr[low];
		}
		srcArr[low] = standard;
		return low;
	}

	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}

}
