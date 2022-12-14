package eulerProject.problems.problems1To100.problems31To40.problem37;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem37 {

	public static void main(String[] args) {
		final int count = 11;
		int n = 10; // partida para los primos a buscar
		List<Long> primosTruncables = new ArrayList<>(10); 
		
		while(primosTruncables.size()<count) {		
			if (Math2.isTruncablePrime(n)) {
				primosTruncables.add(Long.valueOf(n));
			}
			n++;
		}
		
		System.out.println(primosTruncables.toString());
		System.out.println(primosTruncables.stream().reduce(0L, Long::sum));
	}
}
