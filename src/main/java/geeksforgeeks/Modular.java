package geeksforgeeks;

import java.util.ArrayList;
import java.util.Iterator;

public class Modular {
	
	public static void printRequiredValue(ArrayList<Integer> a,ArrayList<Integer> b, Integer m) {
		Integer n = a.size();
		ArrayList<Integer> countA = new ArrayList<Integer>();
		ArrayList<Integer> countB = new ArrayList<Integer>();
		for(Integer i=0;i<m;i++) {
			countA.add(0);
			countB.add(0);
		}
		for(Integer i=0;i<n;i++) {
			countA.set(a.get(i), countA.get(a.get(i))+1);
			countB.set(b.get(i), countB.get(b.get(i))+1);
		}
		System.out.println(countA);
		System.out.println(countB);
		Iterator iteA = countA.iterator();
		Iterator iteB = countB.iterator();
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();
		while(iteA.hasNext() && iteB.hasNext()) {
			sbA.append(iteA.next());
			sbB.append(iteB.next());
		}
		System.out.println(sbA);
		System.out.println(sbB);
		System.out.println((sbB.toString()+sbB.toString()).indexOf(sbA.toString()));
	}

}
