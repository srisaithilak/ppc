package geeksforgeeks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

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
	
	public static void printGcd(Integer a, Integer b) {
		LinkedHashMap<Integer, Integer> primeFactorMapA = getPrimeFactors(a);
		LinkedHashMap<Integer, Integer> primeFactorMapB = getPrimeFactors(b);
		LinkedHashMap<Integer, Integer> primeFactorMapIntersection = getIntersectionLinkedHashMap(primeFactorMapA,primeFactorMapB);
		Integer gcd = buildNumberFromPrimeFactorMap(primeFactorMapIntersection);
		System.out.println("GCD of "+a+" and "+b+" is "+gcd);
	}
	
	private static Integer buildNumberFromPrimeFactorMap(LinkedHashMap<Integer, Integer> primeFactorMapIntersection) {
		Integer response = 1;
		Set<Integer> keySet = primeFactorMapIntersection.keySet();
		Iterator<Integer> ite = keySet.iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			response = (int) (response * Math.pow(key, primeFactorMapIntersection.get(key)));
		}
		return response;
	}
	
	private static LinkedHashMap<Integer, Integer> getIntersectionLinkedHashMap(LinkedHashMap<Integer, Integer> primeFactorMapA, LinkedHashMap<Integer, Integer> primeFactorMapB){
		LinkedHashMap<Integer, Integer> response = new LinkedHashMap<Integer, Integer>();
		Set<Integer> keySetA = primeFactorMapA.keySet();
		Set<Integer> keySetB = primeFactorMapB.keySet();
		Iterator<Integer> iteA = keySetA.iterator();
		while(iteA.hasNext()) {
			Integer key = iteA.next();
			if(keySetB.contains(key)) {
				response.put(key, Math.min(primeFactorMapA.get(key), primeFactorMapB.get(key)));
			}
		}
		return response;
	}

}
