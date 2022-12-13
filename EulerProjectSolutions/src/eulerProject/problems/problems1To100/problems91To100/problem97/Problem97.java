package eulerProject.problems.problems1To100.problems91To100.problem97;

import java.math.BigInteger;

public class Problem97 {

	public static void main(String[] args) {
		BigInteger pow2 = BigInteger.valueOf(2).pow(7830457);
		BigInteger mersenne = BigInteger.valueOf(28433).multiply(pow2);
		mersenne = mersenne.add(BigInteger.ONE);
		
		String str = mersenne.toString();
		
		System.out.println(str.substring(str.length()-10));
	}

}
