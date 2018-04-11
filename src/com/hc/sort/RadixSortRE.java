package com.hc.sort;

public class RadixSortRE {

	public static void main(String[] args) {
		RadixSortRE rs = new RadixSortRE();
		int[] sourceArr = {2314,5428,373,2222,17,789,33,17,997};
		rs.print(sourceArr);	
		rs.print(rs.sort(sourceArr));
	}
	
	private int[] sort(int[] arr){
		int maxLen = getMaxLen(arr);
		arr = radixSort(arr,0,maxLen);
		return arr;
	}
	
	
	private int[] radixSort(int[] arr, int digit, int maxLen) {
		if (digit >= maxLen) {
			return arr;
		}
		int arrLen = arr.length;
		final int radix = 10;
		int[] numBucket = new int[radix];
		int[] temp = new int[arrLen];
		for (int i = 0; i < arrLen; i++) {
			numBucket[getDigitNum(arr[i], digit)]++;
		}
		for (int i = 1; i <radix; i++) {
			numBucket[i] = numBucket[i] + numBucket[i-1];
		}
		for (int i = arrLen- 1; i >= 0; i--) {
			int d = getDigitNum(arr[i], digit);
			temp[numBucket[d]-1] = arr[i];
			numBucket[d]--;
		}
		return radixSort(temp, digit+1, maxLen);
	}

	private int getDigitNum(int num,int digit){
		String s = "" + num;
		if (s.length()-1 < digit) {
			return 0;
		} 
		char c = s.charAt(s.length()-1-digit);
		return Character.getNumericValue(c);
	}
	
	private int getMaxLen(int[] arr) {
		int maxNum = getMaxNum(arr);
		return String.valueOf(maxNum).length();
	}

	private int getMaxNum(int[] arr) {
		int maxNum = 0;
		for (int i = 0; i < arr.length; i++) {
			maxNum = maxNum > arr[i]? maxNum:arr[i];
		}
		return maxNum;
	}

	public  void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}
	
}
