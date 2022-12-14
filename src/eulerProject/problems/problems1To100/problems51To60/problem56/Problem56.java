package eulerProject.problems.problems1To100.problems51To60.problem56;

import java.math.BigInteger;

import eulerProject.library.Math2;

public class Problem56 {

	public static void main(String[] args) {
		long maxSum = 0L;
		
		for (int a=1;a<100;a++) {
			for (int b=1;b<100;b++) {
				long sum = Math2.sumaDigitos(BigInteger.valueOf(a).pow(b));
				
				if (sum>maxSum) {
					maxSum=sum;
				}
			}
		}
		
		System.out.println("La suma máxima de los dígitos es:" + maxSum);
	}

}
