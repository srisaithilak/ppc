package geeksforgeeks;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class PrimeNumbers {

	public static void printPrimes(Integer limit) {
		Instant start = Instant.now();
		ArrayList<Boolean> primesMarker = new ArrayList<Boolean>(limit+1);
		for(int i=0;i<=limit;i++) {
			primesMarker.add(true);
		}
		for(int i=4;i<=limit;i=i+2) {
			primesMarker.set(i, false);
		}
		for(int i=3;i*i<=limit;i=i+2) {
			if(primesMarker.get(i)) {
				for(int j=2*i;j<=limit;j=j+i) {
					primesMarker.set(j, false);
				}
			}
		}
		Integer count = 0;
		for(int i=2;i<=limit;i++) {
			if(primesMarker.get(i)) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("Number of primes is: "+count);
		Instant end = Instant.now();
		System.out.println("Duration for Sieve of Erathosthenes: "+Duration.between(start, end).toMillis());
	}
	
	public static Boolean checkPrime(int number) {
		Boolean response = true;
		for(int i=2;i*i<=number;i++) {
			if(number%i==0) {
				response = false;
				break;
			}
		}
		return response;
	}
}