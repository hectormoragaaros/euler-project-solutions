package eulerProject.problems.problems1To100.problems31To40.problem35;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem35 {

	public static void main(String[] args) {
		int contador = 0;
		List<Integer> listaPrimes = new ArrayList<>();
		
		for (int i=2;i<1000000;i++) {
			if (Math2.isPrime(i)) {
				listaPrimes.add(i);
			}
		}
		
		for (int j=0;j<listaPrimes.size();j++) {
			if (Math2.isCircularPrime(listaPrimes.get(j))) {
				System.out.println("primo circular encontrado:"+listaPrimes.get(j));
				contador++;
			}
		}
		System.out.println("El total de primos circulares menores a 1 millón es:" + contador);
	}

}
