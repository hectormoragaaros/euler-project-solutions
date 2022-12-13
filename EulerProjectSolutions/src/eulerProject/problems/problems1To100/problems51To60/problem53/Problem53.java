package eulerProject.problems.problems1To100.problems51To60.problem53;

import java.math.BigInteger;

import eulerProject.library.Math2;

public class Problem53 {

	public static void main(String[] args) {
		final long maxValue = 1000000L;
		int count=0;
		
		for (int n=23;n<=100;n++) {
			int suma = 0;
			for (int r=0;r<=n;r++) {
				BigInteger num = Math2.combinatoria(n, r);

				if (num.longValue()>maxValue) {
					suma++;
					count++;
				}
			}
			System.out.println("n:"+n+" suma:"+suma);
		}
		
		System.out.println("La cantidad de combinarorias mayores a "+maxValue+":"+count);
	}

}
