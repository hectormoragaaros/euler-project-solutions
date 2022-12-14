package eulerProject.problems.problems1To100.problems41To50.problem50;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem50 {
	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i < 10000; i++) {
			if (Math2.isPrime(i)) {
				primes.add(i);
			}
		}

		int maxFirstTerm = 0;
		int maxCantTerms = 0;
		long maxPrime = 0L;

		// genero un map con la suma de consecutivos como clave y como valor un par de
		// numeros
		// el primero es el primer termino y el segundo la cantidad de primos
		// consecutivos
		for (int i = 0; i < primes.size() - 1; i++) {
			int firstTerm = primes.get(i);

			for (int j = i + 2; j < primes.size(); j++) {
				List<Integer> subList = primes.subList(i + 1, j);
				long suma = firstTerm + subList.stream().map(Long::valueOf).reduce(0L, Long::sum);

				if (Math2.isPrime(suma) && suma < 1000000 && (subList.size() > maxCantTerms)) {
					maxPrime = suma;
					maxCantTerms = subList.size();
					maxFirstTerm = firstTerm;
				}
			}
		}

		System.out.println("primo:" + maxPrime + " " + maxFirstTerm + "+... " + (maxCantTerms + 1) + " términos");
	}
}
