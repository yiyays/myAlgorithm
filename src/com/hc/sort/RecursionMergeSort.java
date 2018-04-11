package com.hc.sort;

public class RecursionMergeSort {

	public static void main(String[] args) {
		int[] sourceArr ={57,59,52,77,79,29,65,54,22,77};	
		print(sourceArr);
		RecursionMergeSort rms = new RecursionMergeSort();
		rms.sort(sourceArr);
		print(sourceArr);

	}
	
	public void sort(int[] sourceArr){
		int[] temp = new int[sourceArr.length];
		recursionMerge(sourceArr, 0, sourceArr.length-1,temp);
		
	}
	public void recursionMerge(int[] arr,int start,int end, int[] temp){
		if (start < end) {
			int mid = (start + end)/2;
			recursionMerge(arr, start, mid,temp);
			recursionMerge(arr, mid+1, end,temp);
			merge(arr,start,mid,end,temp);
		}
	}
	

	private void merge(int[] arr, int start, int mid, int end, int[] temp) {
		int startE = mid +1,tempIndex = 0,startBackup = start;
		while (start <= mid && startE <= end) {
			if (arr[start] < arr[startE]) {
				temp[tempIndex++] = arr[start++];
			} else {
				temp[tempIndex++] = arr[startE++];
			}
		}
		while (start<= mid) {
			temp[tempIndex++] = arr[start++];
		}
		while (startE<= end) {
			temp[tempIndex++] = arr[startE++];
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
