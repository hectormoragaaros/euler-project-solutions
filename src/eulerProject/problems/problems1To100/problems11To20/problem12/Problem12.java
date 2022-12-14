package eulerProject.problems.problems1To100.problems11To20.problem12;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem12 {
	public static void main(String[] args) {
		List<Long> divisores = new ArrayList<>();
		long n=1L;
		final int cant=500;
		
		do {
			divisores.clear();
			// se genera el numero triangular
			long tri = Math2.triangular(n); 
			
			divisores = Math2.divisores(tri);
			
			if (divisores.size()>=cant) {break;}
			
			n++;
		} while (divisores.size()<cant);
		
		System.out.println("El número triangular con "+cant+" o más divisores es:" + Math2.triangular(n));
	}	
}
