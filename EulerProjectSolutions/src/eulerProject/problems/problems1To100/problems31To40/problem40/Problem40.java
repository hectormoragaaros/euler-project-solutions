package eulerProject.problems.problems1To100.problems31To40.problem40;

public class Problem40 {

	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder(10000003);
		//strBuilder.append("0.");

		for (int i=1;i<=1000000;i++) {
			strBuilder.append(i);
		}
		
		int pot10 = 1;
		int res = 1;
		
		do {
			int n = Integer.parseInt(strBuilder.substring(pot10-1, pot10));
			System.out.println("d_"+pot10+"="+n);
			res = res*n;
			pot10*=10;
		} while (pot10<=1000000);
		
		System.out.println("El resultado es:" + res);
	}

}
