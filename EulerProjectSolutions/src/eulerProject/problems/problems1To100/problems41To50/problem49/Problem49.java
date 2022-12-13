package eulerProject.problems.problems1To100.problems41To50.problem49;

import java.util.List;
import java.util.stream.Collectors;

import eulerProject.library.Math2;
import eulerProject.library.String2;

public class Problem49 {

	public static void main(String[] args) {
		int[][] distancia;

		for (int num=1000;num<10000;num++) {
			List<Integer> permutaciones = String2.permutaciones(String.valueOf(num))
					.stream().map(Integer::valueOf)
					.filter(x -> x>1000)
					.filter(Math2::isPrime)
					.sorted()
					.collect(Collectors.toList());
			
			if (permutaciones.size()>=2) {
				// lleno una matriz triangular superior con las distancias del
				// elemento fila con el resto de las permutaciones.
				// busco si existen 2 que tengan la misma distancia entre si
				distancia= new int[permutaciones.size()][permutaciones.size()];
				
				for (int fila=0;fila<permutaciones.size();fila++) {
					for (int col=0;col<permutaciones.size();col++) {
						distancia[fila][col]=permutaciones.get(col)-permutaciones.get(fila);
					}
				}
				
				// hago la busqueda, de valores iguales
				for (int fila=0;fila<permutaciones.size()-1;fila++) {
					for (int col=fila+1;col<permutaciones.size();col++) {
						// tengo la distancia entre el elemento en la
						// posicion fila y el pos col
						int distF1 = distancia[fila][col];
						// busco en la fila con valor col si existe
						// un elemento con el mismo valor
						for (int col2=0;col2<permutaciones.size();col2++) {
							if (distancia[col][col2]==distF1) {
								System.out.println("Eureka!");
								System.out.println(permutaciones.get(fila)+" "+permutaciones.get(col)+" "+permutaciones.get(col2));
							}
						}
					}
				}
			}	
		}
	}
}