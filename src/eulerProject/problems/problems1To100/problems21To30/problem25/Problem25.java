package eulerProject.problems.problems1To100.problems21To30.problem25;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem25 {

	public static void main(String[] args) {
		int n = 0;
		String result;
		
		do {
			n++;
			result = fibonacci(n).toString();
			System.out.println("el factorial "+n+"! tiene "+result.length() +" dígitos");
		} while (result.length()<1000);
		
	}

	public static BigInteger fibonacci(int n) {
		BigDecimal part1 = BigDecimal.valueOf(1/Math.sqrt(5));
		BigDecimal part2 = BigDecimal.valueOf((1+Math.sqrt(5))/2).pow(n);
		BigDecimal part3 = BigDecimal.valueOf((1-Math.sqrt(5))/2).pow(n);
		BigDecimal result = part1.multiply(part2.subtract(part3));
		
		return result.toBigInteger();
	}
}
