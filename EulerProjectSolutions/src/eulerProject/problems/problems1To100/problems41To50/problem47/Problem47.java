package eulerProject.problems.problems1To100.problems41To50.problem47;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eulerProject.library.Math2;
import eulerProject.library.Pair;

public class Problem47 {

	public static void main(String[] args) {
		Map<Long, List<Pair<Long>>> factoresPrimos = new HashMap<>();
		
		for (long i = 2L; i < 1000000L; i++) {
			if (!factoresPrimos.containsKey(i)) {
				// se calculan los factores primos
				List<Pair<Long>> primeFactors = Math2.primeFactors(i);
				// se agregan al map, solo los que tienen 4 factores o mas
				if (primeFactors.size()>=4) {
					factoresPrimos.put(i, primeFactors);
				}
			}
			
			// luego se revisa si existen los 4 valores consecutivos anteriores
			// y si esos 4 tienen 4 o mas factores primos se termina el ciclo
			boolean existenFactoresPrimosConsecutivos =
					factoresPrimos.containsKey(i) &&
					factoresPrimos.containsKey(i-1) &&
					factoresPrimos.containsKey(i-2) &&
					factoresPrimos.containsKey(i-3);
			if (existenFactoresPrimosConsecutivos) {
				boolean tienenCuatroFactores = (factoresPrimos.get(i).size()==4) &&
						(factoresPrimos.get(i-1).size()==4) &&
						(factoresPrimos.get(i-2).size()==4) &&
						(factoresPrimos.get(i-3).size()==4);
						
				if (tienenCuatroFactores) {
					System.out.println("Los cuatro enteros consecutivos con 4 factores primos:"+(i-3)+","+(i-2)+","+(i-1)+","+i);
					System.out.println(mostrarFactores(i-3, factoresPrimos.get(i-3)));
					System.out.println(mostrarFactores(i-2, factoresPrimos.get(i-2)));
					System.out.println(mostrarFactores(i-1, factoresPrimos.get(i-1)));
					System.out.println(mostrarFactores(i, factoresPrimos.get(i)));
					break;
				}
			}
		}
	}

	private static String mostrarFactores(long l, List<Pair<Long>> factores) {
		StringBuilder strBldr = new StringBuilder(String.valueOf(l)).append(":");
		
		for (int i=0;i<factores.size();i++) {
			if (i==0) {
				strBldr = strBldr.append("[");
				strBldr = (factores.get(i).getExp()>1)?strBldr.append(String.valueOf(factores.get(i).getBase())).append("^").append(String.valueOf(factores.get(i).getExp())):
					strBldr.append(String.valueOf(factores.get(i).getBase()));
 			} else if (i==factores.size()-1) {
				strBldr = (factores.get(i).getExp()>1)?strBldr.append("x").append(String.valueOf(factores.get(i).getBase())).append("^").append(String.valueOf(factores.get(i).getExp())):
					strBldr.append("x").append(String.valueOf(factores.get(i).getBase()));
				strBldr = strBldr.append("]");	
			} else {
				strBldr = (factores.get(i).getExp()>1)?strBldr.append("x").append(String.valueOf(factores.get(i).getBase())).append("^").append(String.valueOf(factores.get(i).getExp())):
					strBldr.append("x").append(String.valueOf(factores.get(i).getBase()));
			}
		}
		
		return strBldr.toString();
	}
}
