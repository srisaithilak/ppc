package geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Factors {
	
	public static void printFactors(Integer number) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int count=0;
		for(int i=1;i*i<=number;i++) {
			if(number%i==0) {
				count++;
				System.out.println(i);
				if(i!=(number/i)) {
					factors.add(number/i);
				}
			}
		}
		for(int i=factors.size()-1;i>=0;i--) {
			count++;
			System.out.println(factors.get(i));
		}
		System.out.println("Number of factors: "+count);
	}
	
	public static void printPrimeFactors(Integer number) {
		Integer numberCopy = number;
		int currentNumber = 2;
		int currentFrequency = 0;
		while(number%currentNumber==0) {
			currentFrequency++;
			number/=currentNumber;
		}
		if(currentFrequency>0) {
			System.out.println("Prime Factor: "+currentNumber+" evenly divides "+numberCopy+" "+currentFrequency+" time(s)");
		}
		for(currentNumber=3;currentNumber*currentNumber<=number;currentNumber=currentNumber+2) {
			currentFrequency = 0;
			while(number%currentNumber==0) {
				currentFrequency++;
				number/=currentNumber;
			}
			if(currentFrequency>0) {
				System.out.println("Prime Factor: "+currentNumber+" evenly divides "+numberCopy+" "+currentFrequency+" time(s)");
			}
		}
		if(number>1) {
			System.out.println("Prime Factor: "+number+" evenly divides "+numberCopy+" 1 time(s)");
		}
	}

	public static LinkedHashMap<Integer, Integer> getPrimeFactors(Integer number) {
		LinkedHashMap<Integer, Integer> primeFactorMap = new LinkedHashMap<Integer, Integer>();
		int currentNumber = 2;
		int currentFrequency = 0;
		while(number%currentNumber==0) {
			currentFrequency++;
			number/=currentNumber;
		}
		if(currentFrequency>0) {
			primeFactorMap.put(currentNumber, currentFrequency);
		}
		for(currentNumber=3;currentNumber*currentNumber<=number;currentNumber=currentNumber+2) {
			currentFrequency = 0;
			while(number%currentNumber==0) {
				currentFrequency++;
				number/=currentNumber;
			}
			if(currentFrequency>0) {
				primeFactorMap.put(currentNumber, currentFrequency);
			}
		}
		if(number>1) {
			primeFactorMap.put(number, 1);
		}
		return primeFactorMap;
	}

}
