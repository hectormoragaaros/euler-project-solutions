package eulerProject.problems.problems1To100.problems21To30.problem29;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem29 {
	public static void main(String[] args) {
		Set<BigInteger> resultados = new HashSet<>();
		Map<Integer, Integer> repetidos = new HashMap<>();
		
		for (int a=2;a<=100;a++) {
			
			for (int b=2;b<=100;b++) {
				BigInteger potencia = new BigInteger(String.valueOf(a)).pow(b);
				
				if (!resultados.add(potencia)) {
					repetidos.put(a, b);
				}
			}
		}
		
		System.out.println("El total de terminos es:" + resultados.size());

		System.out.print("Terminos repetidos:");
		for (Map.Entry<Integer, Integer> entry : repetidos.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			
			System.out.print("("+ key + ", " + val+") ");
		}
		System.out.println();
	}
}
