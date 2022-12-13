package eulerProject.problems.problems1To100.problems1To10.problem5;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static void main(String[] args) {
		// creo una lista de enteros (que corresponderan a los factores primos de los
		// números)
		List<Integer> factoresPrimos = new ArrayList<>();
		// creo arreglo de los números a calcular
		int[] arr = new int[20];
		// lleno arreglo
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		while (!arregloUnitario(arr)) {
			int maxElem = maxElemento(arr);

			for (int divisor = 2; divisor < maxElem; divisor++) {
				while (tieneDivisibles(arr, divisor)) {
					arr = dividirArreglo(arr, divisor);
					factoresPrimos.add(divisor);
				}
			}
		}

		System.out.println(
				"El minimo número que es divisible por los números del 1 al 20 es:" + producto(factoresPrimos));
	}

	private static long producto(List<Integer> factoresPrimos) {
		return factoresPrimos.stream().map(x -> Long.valueOf(x.longValue())).reduce(1L, (a, b) -> a * b);
	}

	private static boolean tieneDivisibles(int[] arr, int divisor) {
		boolean resultado = false;

		for (int i = 0; i < arr.length; i++) {
			resultado = (arr[i] % divisor == 0);

			if (resultado) {
				break;
			}
		}

		return resultado;
	}

	private static int[] dividirArreglo(int[] arr, int divisor) {
		int[] b = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			b[i] = ((arr[i] != 1) && (arr[i] % divisor == 0)) ? arr[i] / divisor : arr[i];
		}

		return b;
	}

	private static int maxElemento(int[] arr) {
		int resultado = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > resultado) {
				resultado = arr[i];
			}
		}

		return resultado;
	}

	private static boolean arregloUnitario(int[] arr) {
		boolean resultado = true;

		for (int i = 0; i < arr.length; i++) {
			resultado = resultado && (arr[i] == 1);

			if (!resultado) {
				break;
			}
		}

		return resultado;
	}
}
