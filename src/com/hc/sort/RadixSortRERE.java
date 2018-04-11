package com.hc.sort;

public class RadixSortRERE {

	public static void main(String[] args) {
		RadixSortRERE rs = new RadixSortRERE();
		int[] sourceArr = {2314,5428,373,2222,17,789,33,17,997};
		rs.print(sourceArr);	
		rs.print(rs.sort(sourceArr));

	}
	
	private int[] sort(int[] sourceArr) {
		int maxLen = getMaxLen(sourceArr);
		return radixSort(sourceArr,0,maxLen);
	}

	private int[] radixSort(int[] arr, int digit, int maxLen) {
		if (digit >= maxLen) {
			return arr;
		}
		final int radix = 10;
		int[] numCountBucket = new int[radix];
		int[] temp = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			numCountBucket[getDigitNum(arr[i], digit)]++;
		}
		
		for (int i = 1; i < radix; i++) {
			numCountBucket[i] = numCountBucket[i] + numCountBucket[i-1];
		}
		
		for (int i = arr.length-1; i >= 0; i--) {
			int d = getDigitNum(arr[i], digit);
			temp[numCountBucket[d]-1] = arr[i];
			numCountBucket[d]--;
		}
		
		return radixSort(temp, digit + 1, maxLen);
	}

	private int getDigitNum(int number,int digit){
		String num = String.valueOf(number);
		if (digit > num.length()-1) {
			return 0;
		}
		return Character.getNumericValue(num.charAt(num.length()-1-digit));
	}

	private int getMaxLen(int[] sourceArr) {
		int maxNum = getMaxNum(sourceArr);
		return ("" + maxNum).length();
	}

	private int getMaxNum(int[] sourceArr) {
		int temp = 0;
		for (int i = 0; i < sourceArr.length; i++) {
			temp = temp>sourceArr[i]?temp:sourceArr[i];
		}
		return temp;
	}

	public  void print(int[] arr){
		for(int i = 0 ;i<arr.length;i++){
			System.out.print(arr[i] + "  ");			
		}
		System.out.println("");
	}

}
