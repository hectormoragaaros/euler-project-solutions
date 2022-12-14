package eulerProject.problems.problems1To100.problems31To40.problem31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import eulerProject.library.Math2;

public class Problem31 {

	public static void main(String[] args) {
		Set<List<Integer>> combinaciones = new HashSet<>();
		final int[] coinValues = new int[] {1, 2, 5, 10, 20, 50, 100, 200};
		int[] coins;
		final int sum = 200;
		
		for (int a = 0;a<=200;a++) {
			for (int b=0;b<=100;b++) {
				for (int c=0;c<=40;c++) {
					for (int d=0;d<=20;d++) {
						for (int e=0;e<=10;e++) {
							for (int f=0;f<=4;f++) {
								for (int g=0;g<=2;g++) {
									for(int h=0;h<=1;h++) {
										
										coins = new int[] {a,b,c,d,e,f,g,h};
										
										if (Math2.productoPunto(coins, coinValues)==sum) {
											combinaciones.add(Arrays.stream(coins).boxed().collect(Collectors.toList()));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("la cantidad de combinaciones:" + combinaciones.size());
	}

}
