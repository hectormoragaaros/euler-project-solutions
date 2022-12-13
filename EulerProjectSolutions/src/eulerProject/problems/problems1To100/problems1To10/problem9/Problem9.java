package eulerProject.problems.problems1To100.problems1To10.problem9;

public class Problem9 {
	public static void main(String[] args) {
		double c;
		
		for (int a=1;a<1000;a++) {
			for (int b=1;b<1000;b++) {
				if (a<b) {
					c = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
					
					if ((c<1000) && (a+b+c==1000)) {
						System.out.println("Se encontraron los valores. a="+a+", b="+b+", c="+c);
						System.out.println("El producto a*b*c="+(a*b*((int)c)));
					}				
				}
			}
		}		
	}
}
