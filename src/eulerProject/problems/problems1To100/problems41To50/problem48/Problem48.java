package eulerProject.problems.problems1To100.problems41To50.problem48;

import java.math.BigInteger;

public class Problem48 {

	public static void main(String[] args) {
		BigInteger suma = BigInteger.valueOf(0L);
		
		for (int i=1;i<=1000;i++) {
			suma=suma.add(new BigInteger(String.valueOf(i)).pow(i));
		}
		
		String str = suma.toString();
		
		System.out.println("los 10 ultimos digitos son:"+str.substring(str.length()-10));
	}

}
