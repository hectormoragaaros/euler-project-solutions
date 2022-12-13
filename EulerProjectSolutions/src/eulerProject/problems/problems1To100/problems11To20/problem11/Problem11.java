package eulerProject.problems.problems1To100.problems11To20.problem11;

import java.util.Arrays;

public class Problem11 {
	public static void main(String[] args) {
		ArregloNumerico arreglo = new ArregloNumerico(4);
		
		int mult = arreglo.getMultMaxima();
		int[] arr = arreglo.getArrMultMax();
		String direccion = arreglo.getDireccion();
		
		System.out.println("El arreglo:" + Arrays.toString(arr) + " tiene multiplicacion:" + mult + " y su direccion es " + direccion);
		
	}
}
