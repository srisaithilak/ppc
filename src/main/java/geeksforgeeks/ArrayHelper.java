package geeksforgeeks;

import java.util.Arrays;

public class ArrayHelper {
	
	public static void printLeftRotatedArray(int[] arr,int number) {
		number = number % arr.length;
		if(number!=0) {
			Integer gcd = Factors.gcd2(arr.length, number);
			for(Integer i=0;i<gcd;i++) {
				Integer currentIndex = 0;
				Integer currentValue = arr[currentIndex];
				do {
					Integer nextIndex = (currentIndex-number+arr.length)%arr.length;
					Integer temp = arr[nextIndex];
					arr[nextIndex]=currentValue;
					currentValue=temp;
					currentIndex=nextIndex;
				}while(currentIndex!=0);
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printMaxSum(int[] arr, int number) {
		if(number>arr.length) {
			System.out.println("Bad input for number");
		}else {
			Integer maxSum = 0;
			for(int i=0;i<number;i++) {
				maxSum+=arr[i];
			}
			Integer slidingSum = maxSum;
			for(int i=number;i<arr.length;i++) {
				slidingSum = slidingSum + arr[i] - arr[i-number];
				if(slidingSum>maxSum) {
					maxSum = slidingSum;
				}
			}
			System.out.println("Max sum: "+maxSum);
		}
	}

}
