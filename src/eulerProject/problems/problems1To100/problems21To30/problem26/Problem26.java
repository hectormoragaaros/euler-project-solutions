package eulerProject.problems.problems1To100.problems21To30.problem26;

import java.math.BigInteger;

import eulerProject.library.String2;

public class Problem26 {

	public static void main(String[] args) {
		/* basandose en la respuesta de 
		 * https://math.stackexchange.com/questions/377683/length-of-period-of-decimal-expansion-of-a-fraction#:~:text=The%20length%20of%20the%20period%20is%20given%20by%20the%20multiplicative,where%20q%20is%20your%20quotient.
		 *
		 * la idea es poder encontrar el primer n (entero) que cumple:
		 *   10^n % d = 1 
		 */	
		final int numerador = 1;
		int maxD = 0;
		int maxPeriodo = 0;
		
		for (int d=2;d<1000;d++) {
			int denominador = d;
			
			String[] result = String2.fractionToDecimal(numerador, denominador);
			//result[0] = el decimal en el formato del ejemplo (ver arch README.md)
			//result[1] = el periodo
			if (result[1].length()>maxPeriodo) {
				maxPeriodo = result[1].length();
				maxD = d;
			}
			
			StringBuilder strBuilder = new StringBuilder();
			strBuilder
				.append(String.valueOf(numerador))
				.append("/")
				.append(String.valueOf(denominador))
				.append(" = ");
			
			if (result[1].isEmpty()) {
				strBuilder.append(BigInteger.ONE.divide(BigInteger.valueOf(denominador)).toString());
			} else {
				strBuilder.append(String.valueOf(numerador/denominador)).append(".").append(result[0]);
			}
			System.out.println(strBuilder.toString());
		}
		System.out.println("El período máximo se da con d="+maxD+" con largo " + maxPeriodo);
	}
}
