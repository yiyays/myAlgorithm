package com.hc.sort;

public class RecursionMergeSortRE {

	public static void main(String[] args) {
		int[] sourceArr ={57,59,52,77,79,29,65,54,22,77};	
		print(sourceArr);
		sort(sourceArr);
		print(sourceArr);
		
	}
	
	private static void sort(int[] sourceArr) {
		if (sourceArr.length>0) {
			int[] temp = new int[sourceArr.length];
			recursionMerge(sourceArr,0,sourceArr.length-1,temp);
		}
	}

	private static void recursionMerge(int[] sourceArr, int start, int end, int[] temp) {
		if (start < end) {
			int mid = (start + end)/2;
			recursionMerge(sourceArr, start, mid, temp);
			recursionMerge(sourceArr, mid+1, end, temp);
			merge(sourceArr,start,mid,end,temp);
		}
		
	}

	private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
		int startBackup = start,tempIndex = 0,startRight = mid +1;
		while (start <= mid && startRight <= end) {
			if (arr[start] < arr[startRight]) {
				temp[tempIndex++] = arr[start++];
			} else {
				temp[tempIndex++] = arr[startRight++];
			}
		}
		while (start <= mid) {
			temp[tempIndex++] = arr[start++];
		}
		while (startRight <= end) {
			temp[tempIndex++] = arr[startRight++];
		}
		for (int i = 0; i < tempIndex; i++) {
			arr[startBackup+i] = temp[i];
		}
	}

	public static void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}
}
