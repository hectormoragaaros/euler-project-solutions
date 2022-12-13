package eulerProject.problems.problems1To100.problems31To40.problem34;

import java.util.ArrayList;
import java.util.List;

import eulerProject.library.Math2;

public class Problem34 {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		
		for (int i=3;i<10000000;i++) {
			String x = String.valueOf(i);
			long sum = 0;
			
			for (int digitIdx=0;digitIdx<x.length();digitIdx++) {
				int digit = Integer.parseInt(x.substring(digitIdx, digitIdx+1));
				
				long num = Math2.factorial(digit);
				sum+=num;
			}
			
			if (sum==i) {
				numeros.add(i);
			}
		}
		
		int res = numeros.stream().reduce(0, Integer::sum);
		System.out.println(numeros.toString());
		System.out.println("Resultado="+res);
	}
}
