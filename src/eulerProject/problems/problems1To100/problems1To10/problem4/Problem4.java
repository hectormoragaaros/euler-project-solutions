package eulerProject.problems.problems1To100.problems1To10.problem4;

import eulerProject.library.String2;

public class Problem4 {
	public static void main(String[] args) {
		int palindrome = 0;
		int maxI = 0;
		int maxJ = 0;

		for (int i = 999; i >= 101; i--) {
			for (int j = i - 1; j >= 100; j--) {
				int prod = i*j;
				if (String2.isPalindrome(String.valueOf(prod))) {
					System.out.println("Palindrome encontrado:" + i +"*"+j+"="+prod);
					if (prod > palindrome) {
						palindrome = prod;
						maxI = i;
						maxJ = j;
					}
				}
			}
		}
		System.out.println("El palíndrome más grande encontrado es el producto de "+maxI+"*"+maxJ+"="+palindrome);
	}
}
