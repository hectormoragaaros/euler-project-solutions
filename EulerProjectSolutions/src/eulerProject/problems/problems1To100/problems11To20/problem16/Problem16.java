package eulerProject.problems.problems1To100.problems11To20.problem16;

import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		BigInteger num = BigInteger.valueOf(2).pow(1000);
		
		String numStr = num.toString();
		long suma = 0;
		
		for (int i=0; i<numStr.length();i++) {
			String digit = numStr.substring(i,i+1);
			suma += Long.parseLong(digit);
		}
		
		System.out.println("La suma de los dígitos de 2^1000 es:" + suma);
	}
}
