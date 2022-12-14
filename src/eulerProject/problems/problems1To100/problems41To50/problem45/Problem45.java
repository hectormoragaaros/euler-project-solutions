package eulerProject.problems.problems1To100.problems41To50.problem45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eulerProject.library.Math2;

public class Problem45 {
	// se igualan los terminos generales para las series triangulares, pentagonales y hexagonales.
	// sea a el valor n de la serie triangular, b el de la serie pentagonal y c el de la hexagonal
	// se obtiene las sgtes ecs de segundo grado:
	//
	// i) 3b^2-b-a^2-a=0
	// ii) 4c^2-2*c-a^2-a=0
	//
	// resolviendo dichas ecs se obtiene:
	//
	// b = (1+sqrt(12*a^2+12*a+1))/6
	//
	// c = (1+sqrt(4*a^2+4*a+1))/4
	// NOTA: esta opcion no me funciono!!!
	/*public static void main(String[] args) {
		for (int a=1;a<10000;a++) {
			long calcb = (long)(12*Math.pow(a, 2)+12*a+1);
			long calcc = (long)(4*Math.pow(a, 2)+4*a+1);
			
			if (Math2.isPerfectSquareWithOptimization(calcb) && (Math2.isPerfectSquareWithOptimization(calcc))) {
				int b = (1+(int)Math.sqrt(calcb))/6;
				int c = (1+(int)Math.sqrt(calcc))/4;
				
				System.out.println("Encontrados los valores: a="+a+" b="+b+" c="+c);
				System.out.println("T_"+a+" = P_"+b+" = H_" + c +" = " + Math2.triangular(a));
			}
			
		}
	}*/

	public static void main(String[] args) {
		List<Long> triangulares = new ArrayList<>();
		List<Long> pentagonales = new ArrayList<>();
		List<Long> hexagonales = new ArrayList<>();
		List<Long> resultado = new ArrayList<>();
		
		for (long n=1L;n<100000L;n++) {
			triangulares.add(Math2.triangular(n));
			pentagonales.add(Math2.pentagonal(n));
			hexagonales.add(Math2.hexagonal(n));
		}
		
		for (Long num : triangulares) {
			if (pentagonales.contains(num) && hexagonales.contains(num)) {
				resultado.add(num);
			}
		}
		
		Collections.sort(resultado);
		
		System.out.println(resultado.toString());
	}
}
