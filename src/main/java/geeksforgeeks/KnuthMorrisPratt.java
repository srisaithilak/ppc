package geeksforgeeks;

import java.util.Arrays;

public class KnuthMorrisPratt {
	
	public static Integer subStringSearch(String a, String pattern) {
		//KMP algorithm
		//Knuth-Morris-Pratt Algo
		Integer patternLength = pattern.length();
		int[] piTable = new int[patternLength+1];
		piTable[0]=0;
		piTable[1]=0;
		Integer matchedCount = 0;
		for(Integer i=1;i<patternLength;i++) {
			//continuation
			if(pattern.charAt(i)==pattern.charAt(0+matchedCount)) {
				piTable[i+1]=piTable[i]+1;
				matchedCount++;
			}else if(pattern.charAt(i)==pattern.charAt(0)) {
				piTable[i+1]=1;
				matchedCount=1;
			}else {
				piTable[i+1]=0;
				matchedCount=0;
			}
		}
		//System.out.println(Arrays.toString(piTable));
		Integer stringLength = a.length();
		Integer j = 0;
		for(Integer i=0;i<stringLength;i++) {
			if(a.charAt(i)==pattern.charAt(j)) {
				j++;
				if(j==patternLength) {
					//System.out.println("Pattern found at "+(i-patternLength+1));
					return i-patternLength+1;
				}
			}else if(j!=0){
				j=piTable[j];
				i--;
			}else {
				//do nothing
			}
		}
		return -1;
	}
	
	public static void printPiTable(String pattern) {
		int[] piTable = new int[pattern.length()+1];
		for(int i=2;i<=pattern.length();i++) {
			if(piTable[i-1]!=0 && pattern.charAt(piTable[i-1])==pattern.charAt(i-1)) {
				piTable[i]=piTable[i-1]+1;
			}else if(pattern.charAt(i-1)==pattern.charAt(0)) {
				piTable[i]=1;
			}
		}
		System.out.println(Arrays.toString(piTable));
	}

}
