package eulerProject.problems.problems1To100.problems1To10.problem2;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		List<Integer> fibonacci = new ArrayList<>(2000);
		
		// f(1) = 1
		fibonacci.add(1);
		// f(2) = 1
		fibonacci.add(1);
		
		do {
			int n = fibonacci.size();
			fibonacci.add(fibonacci.get(n-1) + fibonacci.get(n-2));
		} while (fibonacci.get(fibonacci.size()-1) < 4000000);
		
		int sum = 0;
		for (Integer fib : fibonacci) {
			if (fib%2==0) {
				sum+=fib;
			}
		}
		
		System.out.println("La suma de los números de Fibonacci pares es:" + sum);
	}

}
