package eulerProject.problems.problems1To100.problems21To30.problem30;

import java.util.ArrayList;
import java.util.List;

public class Problem30 {
	public static void main(String[] args) {
		List<Long> numeros = new ArrayList<>();
		
		for (long i=10L;i<999999;i++) {
			long valor = quintaPotencia(i);
			
			if (valor==i) {
				numeros.add(i);
			}
		}
		System.out.println(numeros);
		long suma = numeros.stream().reduce(0L, Long::sum);
		System.out.println("la suma es " + suma);
	}

	private static long quintaPotencia(long i) {
		String aux = String.valueOf(i);
		String[] s = new String[aux.length()];
		long suma = 0;
		
		for (int j = 0; j < aux.length(); j++) {
			s[j]=aux.substring(j, j+1);
			suma+=(long)Math.pow(Integer.parseInt(s[j]),5);
		}
		
		return suma;
	}
	
	
}
