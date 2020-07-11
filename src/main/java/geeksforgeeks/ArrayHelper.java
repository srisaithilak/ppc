package geeksforgeeks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

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
	
	public static void printMaxPrefix(int number, LinkedList<DoubleValueHolder> operations) {
		int[] arr = new int[number];
		Iterator<DoubleValueHolder> ite = operations.iterator();
		while(ite.hasNext()) {
			DoubleValueHolder temp = ite.next();
			arr[temp.from - 1]=arr[temp.from - 1]+100;
			if(temp.to!=number) {
				arr[temp.to]=arr[temp.to]-100;
			}
		}
		Integer maxVal = arr[0];
		for(int i=1;i<number;i++) {
			arr[i]=arr[i]+arr[i-1];
			if(arr[i]>maxVal) {
				maxVal=arr[i];
			}
		}
		System.out.println(Arrays.toString(arr)+" with max value "+maxVal);
	}

}
