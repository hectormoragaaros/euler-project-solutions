package eulerProject.problems.problems1To100.problems41To50.problem43;

import java.util.List;

import eulerProject.library.String2;

public class Problem43 {

	public static void main(String[] args) {
		List<String> listaNumerosPandigitales = String2.permutaciones("1234567890");
		Long suma = 0L;
		
		for (String pandigital : listaNumerosPandigitales) {
			boolean divisibleBy2 = (Integer.valueOf(pandigital.substring(1, 4))%2==0);
			boolean divisibleBy3 = (Integer.valueOf(pandigital.substring(2, 5))%3==0);
			boolean divisibleBy5 = (Integer.valueOf(pandigital.substring(3, 6))%5==0);
			boolean divisibleBy7 = (Integer.valueOf(pandigital.substring(4, 7))%7==0);
			boolean divisibleBy11 = (Integer.valueOf(pandigital.substring(5, 8))%11==0);
			boolean divisibleBy13 = (Integer.valueOf(pandigital.substring(6, 9))%13==0);
			boolean divisibleBy17 = (Integer.valueOf(pandigital.substring(7, 10))%17==0);
			
			if (divisibleBy2 && divisibleBy3 && divisibleBy5
					&& divisibleBy7 && divisibleBy11 && divisibleBy13
					&& divisibleBy17) {
				suma+=Long.valueOf(pandigital);
			}
		}
		System.out.println("la suma es:"+suma);
	}

}
