package eulerProject.problems.problems1To100.problems1To10.problem1;

public class Problem1 {

	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1;i<1000; i++) {
			if ((i%3==0)||(i%5==0)) {
				sum +=i;
			}
		}
		System.out.println("La suma de los múltiplos de 3 o 5 es:" + sum);
	}

}
