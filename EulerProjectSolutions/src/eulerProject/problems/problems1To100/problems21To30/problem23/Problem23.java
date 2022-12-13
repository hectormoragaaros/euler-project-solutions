package eulerProject.problems.problems1To100.problems21To30.problem23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import eulerProject.library.Math2;

public class Problem23 {

	public static void main(String[] args) {
		List<Integer> abundantes = new ArrayList<>(28123);
		List<Long> resultado = new ArrayList<>();

		for (int i=2;i<=28123;i++) {
			if (Math2.isAbundante(i)) {
				abundantes.add(i);
			}
		}
		//System.out.println("abundantes calculados:" + abundantes.size());
		
		List<Integer> sumaAbundantes = getListaSumaAbundantes(abundantes);
		//System.out.println("suma de abundantes calculados:" + sumaAbundantes.size());
		
		for (int i=1;i<28123;i++) {
			if (!sumaAbundantes.contains(i)) {
				resultado.add((long)i);
			}
		}
		
		System.out.println("numeros no formados por la suma de 2 abundantes: " + resultado.toString());
		System.out.println("suma:" + resultado.stream().reduce(0L, Long::sum));
	}
	
	public static List<Integer> getListaSumaAbundantes(List<Integer> listaAbundantes){
		Set<Integer> listaSumaAbundantes = new HashSet<>();

		for (int i = 0; i < listaAbundantes.size(); i++) {
			Integer numAbundante = listaAbundantes.get(i);
			
			listaSumaAbundantes.addAll(listaAbundantes
					.stream()
					.map(x -> x + numAbundante)
					.filter(x -> x <= 28123)
					.sorted()
					.collect(Collectors.toList()));	
		}
		
		return new ArrayList<>(listaSumaAbundantes);
	}
}
