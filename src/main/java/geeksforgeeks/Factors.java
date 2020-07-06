package geeksforgeeks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

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
	
	public static void printLcm(Integer a, Integer b) {
		LinkedHashMap<Integer, Integer> primeFactorMapA = getPrimeFactors(a);
		LinkedHashMap<Integer, Integer> primeFactorMapB = getPrimeFactors(b);
		TreeMap<Integer, Integer> primeFactorMapUnion = getUnionTreeMap(primeFactorMapA,primeFactorMapB);
		System.out.println("LCM map: "+primeFactorMapUnion);
		Integer lcm = buildNumberFromPrimeFactorMap(primeFactorMapUnion);
		System.out.println("LCM of "+a+" and "+b+" is "+lcm);
	}

	private static Integer buildNumberFromPrimeFactorMap(TreeMap<Integer, Integer> primeFactorMapUnion) {
		Integer response = 1;
		Set<Integer> keySet = primeFactorMapUnion.keySet();
		Iterator<Integer> ite = keySet.iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			response = (int) (response * Math.pow(key, primeFactorMapUnion.get(key)));
		}
		return response;
	}

	private static TreeMap<Integer, Integer> getUnionTreeMap(LinkedHashMap<Integer, Integer> primeFactorMapA, LinkedHashMap<Integer, Integer> primeFactorMapB){
		TreeMap<Integer, Integer> response = new TreeMap<Integer, Integer>(primeFactorMapA);
		Set<Integer> keySetB = primeFactorMapB.keySet();
		Iterator<Integer> iteB = keySetB.iterator();
		while(iteB.hasNext()) {
			Integer key = iteB.next();
			if(response.containsKey(key)) {
				response.put(key, Math.max(response.get(key), primeFactorMapB.get(key)));
			}else {
				response.put(key, primeFactorMapB.get(key));
			}
		}
		return response;
	}
	
	public static Integer gcd2(Integer a, Integer b) {
		if(a==0) {
			return b;
		}else if(b==0) {
			return a;
		}else {
			return gcd2(b,a%b);
		}
	}
	
	public static Integer lcm2(Integer a, Integer b) {
		return a*b/gcd2(a,b);
	}
	
	public static Integer numZeroesinFactorial(Integer number) {
		Integer divisor = 5;
		Integer numZeroes = 0;
		while(divisor<=number) {
			numZeroes += number/divisor;
			divisor *= 5;
		}
		return numZeroes;
	}
	
	public static void printFactorial(Integer number) {
		System.out.println("Factorial of "+number+" is "+getFactorial((long) number));
	}
	
	private static Long getFactorial(Long number) {
		if(number==1) {
			return (long) 1;
		}else {
			return number*getFactorial(number-1);
		}
	}
}
