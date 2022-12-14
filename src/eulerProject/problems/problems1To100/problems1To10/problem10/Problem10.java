package eulerProject.problems.problems1To100.problems1To10.problem10;

import java.util.ArrayList;
import java.util.List;

public class Problem10 {

	public static void main(String[] args) {
		List<Integer> primeNumbers = new ArrayList<>();
		
		for (int i=2;i<2000000;i++) {
			if (esPrimo(i)) {
				primeNumbers.add(i);
			}
		}
		
		Long suma = primeNumbers.stream()
				.map(x -> Long.valueOf(x.longValue()))
				.reduce(0L, Long::sum);
		System.out.println("La suma es:"+suma);
	}

	public static boolean esPrimo(int num) {
		for (int i=2;i<=(int)Math.sqrt(num);i++) {
			if (num%i==0) {
				return false;
			}
		}
		//System.out.println("" + num+" es primo.");
		return true;
	}
}
