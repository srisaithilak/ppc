package geeksforgeeks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Application {

	public static void main(String[] args) {
		
		LinkedList<DoubleValueHolder> operations = new LinkedList<DoubleValueHolder>();
		operations.add(new DoubleValueHolder(2, 4));
		operations.add(new DoubleValueHolder(1, 3));
		operations.add(new DoubleValueHolder(1, 2));
		ArrayHelper.printMaxPrefix(5, operations);
		
		DoubleValueHolder[] sample = new DoubleValueHolder[2];
		DoubleValueHolder[] newSample = operations.toArray(sample);
		System.out.println(Arrays.toString(sample));
		System.out.println(Arrays.toString(newSample));
		System.out.println(sample==newSample);
		
		Vector<Integer> vecSample = new Vector<Integer>();
		vecSample.add(2);
		/*
		 * ArrayHelper.printMaxSum(new int[] { 100, 200, 300, 400 }, 2);
		 * 
		 * ArrayHelper.printMaxSum(new int[] { 1, 4, 2, 10, 23, 3, 1, 0, 20 }, 4);
		 * ArrayHelper.printMaxSum(new int[] { 2, 3 }, 1); ArrayHelper.printMaxSum(new
		 * int[] { 2, 3 }, 3);
		 */

		// ArrayHelper.printLeftRotatedArray(new int[]{1,2,3,4,5,6}, 6);

		/*
		 * //instance of value holder with value set to 1 ValueHolder sampleValue = new
		 * ValueHolder(1);
		 * 
		 * //original array ValueHolder originalArray[] = { sampleValue };
		 * 
		 * //cloned array ValueHolder clonedArray[] = originalArray.clone();
		 * 
		 * //now modifying the original array's object originalArray[0].value = 10;
		 * 
		 * //printing the value now show modified value because clonedArray is not
		 * deep-copied, reference to original object is copied (shallow copy)
		 * System.out.println(clonedArray[0]);
		 */

		// PrimeNumbers.printPrimes(10000);

		/*
		 * System.out.println("is 39 prime?: "+PrimeNumbers.checkPrime(39));
		 * System.out.println("is 41 prime?: "+PrimeNumbers.checkPrime(41));
		 * System.out.println("is 97 prime?: "+PrimeNumbers.checkPrime(97));
		 * System.out.println("is 67 prime?: "+PrimeNumbers.checkPrime(67));
		 * System.out.println("is 53 prime?: "+PrimeNumbers.checkPrime(53));
		 * System.out.println("is 73 prime?: "+PrimeNumbers.checkPrime(73));
		 * System.out.println("is 75 prime?: "+PrimeNumbers.checkPrime(75));
		 */

		/*
		 * Factors.printFactors(64); Factors.printFactors(128);
		 */

		/*
		 * Factors.printPrimeFactors(81); Factors.printPrimeFactors(64);
		 * Factors.printPrimeFactors(1024); Factors.printPrimeFactors(135);
		 * Factors.printPrimeFactors(75); Factors.printPrimeFactors(82);
		 */

		// System.out.println(Factors.getPrimeFactors(135));

		// Factors.printGcd(729, 81);

		// Factors.printLcm(81, 16);

		// System.out.println(Factors.gcd2(1024, 2));

		// System.out.println(Factors.lcm2(81, 16));

		// Factors.printFactorial(20);

		// System.out.println(Factors.numZeroesinFactorial(20));

		/*
		 * ArrayList<Integer> a = new ArrayList<Integer>(); a.add(0); a.add(0);
		 * a.add(0); a.add(1); a.add(2); ArrayList<Integer> b = new
		 * ArrayList<Integer>(); b.add(2); b.add(1); b.add(0); b.add(0); b.add(0);
		 * Modular.printRequiredValue(a, b, 10);
		 */

		/*
		 * KnuthMorrisPratt.subStringSearch("ababcababdababe", "ababd");
		 * System.out.println(KnuthMorrisPratt.subStringSearch("ababcabcabababd",
		 * "ababd")); KnuthMorrisPratt.subStringSearch("hello", "abcdeabfabc");
		 * KnuthMorrisPratt.subStringSearch("hello", "aabcadaabe");
		 * KnuthMorrisPratt.subStringSearch("hello", "aaaabaacd");
		 * KnuthMorrisPratt.subStringSearch("hello", "abcdabcdeabbcd");
		 * KnuthMorrisPratt.printPiTable("abcdeabfabc");
		 * KnuthMorrisPratt.printPiTable("aabcadaabe");
		 * KnuthMorrisPratt.printPiTable("aaaabaacd");
		 * KnuthMorrisPratt.printPiTable("abcdabcdeabbcd");
		 */

	}

}