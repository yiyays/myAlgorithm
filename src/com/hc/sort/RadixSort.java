package com.hc.sort;

public class RadixSort {

	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] sourceArr = {2314,5428,373,2222,17,789,33,17,997};
		rs.print(sourceArr);				
		rs.print(rs.sort(sourceArr));		
	}
	
	int[] sort(int[] arr) {
		int maxLen = getMaxLen(arr);
		return radixSort(arr,0,maxLen);
	}
	
	private int[] radixSort(int[] arr, int digit, int maxLen) {
		if (digit >= maxLen) {
			return arr;
		}
		final int radix = 10;
		int arrLen = arr.length;
		int[] numBucket = new int[radix];
		int[] temp = new int[arrLen];
		for (int i = 0; i < arrLen; i++) {
			int num = getDigitNum(arr[i], digit);
			numBucket[num]++;
		}
		for (int i = 1; i < radix; i++) {
			numBucket[i] = numBucket[i] + numBucket[i-1];
		}
		for (int i = arrLen-1; i >= 0; i--) {
			int num = arr[i];
			int d = getDigitNum(num, digit);
			temp[(numBucket[d]-1)] = num;
			numBucket[d]--;
		}
		return radixSort(temp, digit+1, maxLen);
	}

	private int getDigitNum(int num,int digit){
		String s = ""+num;
		if (s.length()-1 < digit) {
			return 0;
		}
		char c = s.charAt(s.length()-1-digit);
		return Character.getNumericValue(c);
	}
	private int getMaxLen(int[] arr){
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = max > arr[i]?max:arr[i];
		}
		return getNumLen(max);
	}
	private int getNumLen(int num){
		return String.valueOf(num).length();
	}
	public  void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}

}
