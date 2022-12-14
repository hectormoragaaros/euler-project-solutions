package eulerProject.problems.problems1To100.problems21To30.problem27;

import java.util.HashSet;
import java.util.Set;

import eulerProject.library.Math2;
import eulerProject.library.Pair;

public class Problem27 {

	public static void main(String[] args) {
		//La idea de que n^2+a*n+b genere numeros primos significa que
		//se debe buscar la combinación de a y b tales que no se pueda
		//factorizar el polinomio.
		// al revisar la ec. cuadratica la idea es que a^2-4*b < 0
		
		// busco primero los valores que cumplen la condicion
		Set<Pair<Integer>> set = new HashSet<>();
		
		for (int a=-999;a<1000;a++) {
			for (int b=-1000;b<=1000;b++) {
				if (Math.pow(a,2) < 4*b) {
					set.add(new Pair<Integer>(a,b));
				}
			}
		}
		
		// para cada par reviso cuántos primos consecutivos se pueden generar
		int maxA=Integer.MIN_VALUE;
		int maxB=Integer.MIN_VALUE;
		int maxPrimosConsecutivos = 0;
		
		for (Pair<Integer> pair : set) {
			int total = getPrimosConsecutivos(pair.getBase(), pair.getExp());
			
			if (total > maxPrimosConsecutivos) {
				maxA = pair.getBase();
				maxB = pair.getExp();
				maxPrimosConsecutivos = total;
			}
		}
		
		System.out.println("La mayor cantidad de primos consecutivos (" +maxPrimosConsecutivos+ ") se da con a="+maxA+" b="+maxB);
	}
	
	public static int getPrimosConsecutivos(int a, int b) {
		int cont = 0;
		int n = 0;
		
		while (Math2.isPrime((int)(Math.pow(n, 2)+a*n+b))) {
			System.out.println("n="+n+" a="+a+" b="+b);

			cont++;
			n++;
		}
		
		return cont;
	}
}
