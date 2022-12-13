package eulerProject.problems.problems1To100.problems51To60.problem52;

import eulerProject.library.Math2;

public class Problem52 {

	public static void main(String[] args) {
		long i=1L;
		
		while (!Math2.containsSameDigits(i)) {
			i++;
		}
		
		System.out.println("El mínimo número que posee los mismos dígitos en 1x, 2x, 3x, 4x, 5x y 6x es " + i);
	}

}
