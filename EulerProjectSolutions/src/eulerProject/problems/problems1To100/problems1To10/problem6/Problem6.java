package eulerProject.problems.problems1To100.problems1To10.problem6;

public class Problem6 {
	public static void main(String[] args) {
		int n= 100;
		// suma de los primeros 100 numeros naturales
		int a = n*(n+1)/2;
		// suma de los cuadrados de los primeros 100 numeros naturales
		int b = n*(n+1)*(2*n+1)/6;
		// lo que se pide
		int resta = (int)(Math.pow(a, 2)-b);
		
		System.out.println("difference between the sum of the squares of the first one hundred natural numbers and the square of the sum:" + resta);
	}
}
