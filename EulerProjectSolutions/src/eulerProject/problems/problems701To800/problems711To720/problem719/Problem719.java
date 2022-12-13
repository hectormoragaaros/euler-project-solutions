package eulerProject.problems.problems701To800.problems711To720.problem719;

import java.util.List;
import eulerProject.library.String2;

public class Problem719 {

	public static void main(String[] args) {
		long sumaNums = 0L;
		final long limit = (long)Math.pow(10, 12);

		// genero los cuadrados menores al limit
		for (long i = 4L; i <= (long)Math.sqrt(limit); i++) {
			// con i=4 se tiene un cuadrado de 2 digitos al menos
			long numCuadrado = (long)Math.pow(i, 2);
			
			// generar particiones del número
			List<List<String>> particiones = String2.partitions(String.valueOf(numCuadrado));

			for (List<String> particion : particiones) {
				long suma = particion.stream().map(Long::parseLong).reduce(0L, Long::sum);
				
				if (suma == i) {
					System.out.println("particion:" + particion.toString()+" suma:"+suma);
					sumaNums += numCuadrado;
					// basta con encontrar una particion
					break;
				}
			}
		}
		
		System.out.println("la suma de los nums S es:" + sumaNums);
	}
}
