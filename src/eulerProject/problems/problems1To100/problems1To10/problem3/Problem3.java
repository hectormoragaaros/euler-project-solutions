package eulerProject.problems.problems1To100.problems1To10.problem3;

import java.util.List;

import eulerProject.library.Math2;

public class Problem3 {
	public static void main(String[] args) {
		long n=13195L;
		List<Long> ejemplo = Math2.getPrimeFactors(n);
		System.out.println("Los factores primos de "+n+" son:" + ejemplo);
		long n1 = 600851475143L;
		List<Long> solucion = Math2.getPrimeFactors(n1);
		System.out.println("Los factores primos de "+n1+" son:" + solucion);
	}
}
