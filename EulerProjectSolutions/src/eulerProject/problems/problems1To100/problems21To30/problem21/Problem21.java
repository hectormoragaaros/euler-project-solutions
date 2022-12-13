package eulerProject.problems.problems1To100.problems21To30.problem21;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eulerProject.library.Math2;

public class Problem21 {

	public static void main(String[] args) {
		Set<Integer> resultados = new HashSet<>();
		
		for (int a=1;a<10000;a++) {
			List<Integer> na = Math2.divisoresSinElPropioNumero(a);
			
			int da = na.stream().reduce(0, Integer::sum);
			
			List<Integer> nb = Math2.divisoresSinElPropioNumero(da);
			
			int db = nb.stream().reduce(0, Integer::sum);
			
			if (a==db && a!=da) {
				resultados.add(a);
				resultados.add(da);
			}
		}
		
		System.out.println(resultados.toString());
		System.out.println(resultados.stream().reduce(0, Integer::sum));
	}
}
