package eulerProject.problems.problems1To100.problems11To20.problem14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem14 {
	public static void main(String[] args) {
		int n=1;
		Map<Integer, Integer> collatzChain = new HashMap<>();
		int biggestCollatz=0;
		int biggestCollatzChain=0;
		
		while (n<1000000) {
			collatzChain.put(n, calculateCollatz(n));
			n++;
		}
	
		for (Map.Entry<Integer, Integer> entry : collatzChain.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			
			if (val > biggestCollatzChain) {
				biggestCollatz = key;
				biggestCollatzChain = val;
			}
		}
		System.out.println("La secuencia de Collatz mas larga se da con el número " + biggestCollatz + ":" + biggestCollatzChain + " números");
	}

	private static int calculateCollatz(long n) {
		List<Long> result = new ArrayList<>(200000);
		result.add(n);
		
		while (n!=1) {
			n=(n%2==0)?n/2:3*n+1;
			result.add(n);
		}
		
		return result.size();
	}
}
