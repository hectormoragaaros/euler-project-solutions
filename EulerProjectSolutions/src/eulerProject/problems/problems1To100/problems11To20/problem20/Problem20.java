package eulerProject.problems.problems1To100.problems11To20.problem20;

import java.math.BigInteger;

public class Problem20 {
	public static void main(String[] args) {
		int num = 100;
		BigInteger fact = factorial(new BigInteger(String.valueOf(num)));
		
		String bigNumStr = fact.toString();
		int sum = 0;
		
		for (int i=0;i<bigNumStr.length();i++) {
			sum+=Integer.parseInt(bigNumStr.substring(i, i+1));
		}
		
		System.out.println("La suma de los digitos de "+num+"! es:"+sum);
	}
	
	public static BigInteger factorial (BigInteger n) {
		if (n.longValue()<=1L) {return BigInteger.ONE;}
		else {
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
		}
	}
	
}
