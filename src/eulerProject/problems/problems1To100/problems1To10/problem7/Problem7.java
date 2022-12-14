package eulerProject.problems.problems1To100.problems1To10.problem7;

import eulerProject.library.Math2;

public class Problem7 {
	public static void main(String[] args) {
		int contPrimos = 0;
		long n = 1;
		int limit = 10001;

			do {
				n++;

				if (Math2.isPrime(n)) {
					contPrimos++;
				}
			} while (contPrimos < limit);
			System.out.println("El primo " + contPrimos + " es " + n);
	}
}
