package eulerProject.problems.problems1To100.problems11To20.problem15;

import java.math.BigInteger;

import eulerProject.library.Math2;

public class Problem15 {
	public static void main(String[] args) {
		BigInteger n = BigInteger.valueOf(20);
		// El problema corresponde a una permitacion con repeticion
		// los desplazamientos son de 2 tipos: R(right) y D(down)
		// para un cuadrado de 1x1, los movimientos son 2,
		// para un cuadrado de 2x2, los movimientos son 4,
		// para un cuadrado de 3x3, los movimientos son 6,...
		// para un cuadrado de nxn, los movimientos son 2n
		BigInteger permutacion = Math2.factorial(n.multiply(BigInteger.valueOf(2))).divide((Math2.factorial(n).multiply(Math2.factorial(n))));

		System.out.println(permutacion.toString());
	}
	
}
