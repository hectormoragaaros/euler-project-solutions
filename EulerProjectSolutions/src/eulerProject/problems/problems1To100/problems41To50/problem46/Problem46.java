package eulerProject.problems.problems1To100.problems41To50.problem46;

import java.util.List;

import eulerProject.library.Math2;

public class Problem46 {

	public static void main(String[] args) {
		// los numeros involucrados:
		// i) el impar compuesto puede ser representado por 2*k+1 (y no debe ser primo)
		// ii) el primo puede ser representado por 2*m+1, m>0
		// iii) el doble de un numero al cuadrado puede ser representado por 2*p^2
		//
		// la ecuacion que debe cumplirse es;
		//  2*k+1 = 2*m+1+2*p^2, m>0, p>0
		//  k-m = p^2, donde k>m>0
		
		for (int k=4;k<100000;k++) {
			if (Math2.isPrime(2*k+1)) {continue;}
			long p2=0;
			
			boolean result = false;
			List<Integer> primos = Math2.listaPrimos(2*k+1);
			System.out.println("n:"+(2*k+1)+" "+primos.toString());
			
			for (Integer m : primos) {
				p2 = (2*k+1-m)/2;
				
				if (Math2.isPerfectSquareWithOptimization(p2)) {
					System.out.println(""+(2*k+1)+"="+m+"+2*"+p2);
					result=true;
					break;
				}
			}
			
			if (!result) {
				System.out.println("Valor encontrado n:" + (2*k+1));
				break;
			}
		}
	}
}
