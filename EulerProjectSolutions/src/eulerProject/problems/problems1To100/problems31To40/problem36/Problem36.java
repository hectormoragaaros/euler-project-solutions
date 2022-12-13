package eulerProject.problems.problems1To100.problems31To40.problem36;

import eulerProject.library.String2;

public class Problem36 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i=1;i<1000000;i++) {
			String strNum = String.valueOf(i);
			String strBinario = String2.getBinario(i);
			
			if (String2.isPalindrome(strBinario) && String2.isPalindrome(strNum)) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}
