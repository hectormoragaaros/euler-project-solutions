package eulerProject.problems.problems1To100.problems31To40.problem33;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem33 {
	// Se trata de evaluar 4 posibilidades de fracciones,
	// donde el término a cancelar erroneamente es el b:
	// 
	// i)   ab/cb = a/c
	// ii)  ba/cb = a/c
	// iii) ba/bc = a/c
	// iv)  ab/bc = a/c
	// a = {1,..,9}, b = {0,..9}, c = {1,..,9}

	public static void main(String[] args) {
		// se dan 2 casos no triviales:
		// I)  a*b-9*a*c-10*b*c = 0 (proviene de la ec. ii)
		// II) 10*a*b-9*a*c-b*c = 0 (proviene de la ec. iv)
		List<Integer> nums = new ArrayList<>();
		List<Integer> denoms = new ArrayList<>();
		
		for (int a=1;a<=9;a++) {
			for (int c=1;c<=9;c++) {
				for (int b=0;b<=9;b++) {
					// caso 1)
					if (a*b-9*a*c-10*b*c==0 && a!=c) {
						String numerador = String.valueOf(b).concat(String.valueOf(a));
						String denominador = String.valueOf(c).concat(String.valueOf(b));
						System.out.println("ec. encontrada:" + numerador +"/"+ denominador);
						
						// busco la fraccion reducida
						int gcd = Math2.gcd(a, c);
						int mina = a/gcd;
						nums.add(mina);
						int minc = c/gcd;
						denoms.add(minc);
					}
					// caso 2)
					if (10*a*b-9*a*c-b*c==0 && a!=c) {
						String numerador = String.valueOf(a).concat(String.valueOf(b));
						String denominador = String.valueOf(b).concat(String.valueOf(c));
						System.out.println("ec. encontrada:" + numerador +"/"+ denominador);
						
						// busco la fraccion reducida
						int gcd = Math2.gcd(a, c);
						int mina = a/gcd;
						nums.add(mina);
						int minc = c/gcd;
						denoms.add(minc);						
					}
				}
			}
		}
		
		int x = nums.stream().reduce(1, (a,b) -> a*b);
		int y = denoms.stream().reduce(1, (a,b) -> a*b);
		System.out.println("x:"+x+" y:"+y);
		int gcd =Math2.gcd(x, y); 
		x = x/gcd;
		y = y/gcd;
		
		System.out.println("el valor del denominador es:" + y);
	}
}
