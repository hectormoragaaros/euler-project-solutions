package eulerProject.problems.problems1To100.problems41To50.problem41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eulerProject.library.Math2;
import eulerProject.library.String2;

public class Problem41 {

	public static void main(String[] args) {
		final String digits = "1234567890";
		List<Long> primos = new ArrayList<>();
		
		for (int i=1;i<digits.length();i++) {
			String subDigs = digits.substring(0,i);
			List<String> lista = String2.permutaciones(subDigs);
			
			for (String strNum : lista) {
				long num = Long.parseLong(strNum);
				
				if (Math2.isPrime(num)) {
					primos.add(num);
				}
			}
		}
		
		Collections.sort(primos);
		System.out.println(primos.get(primos.size()-1));
	}

}
