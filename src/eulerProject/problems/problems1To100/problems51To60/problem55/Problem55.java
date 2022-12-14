package eulerProject.problems.problems1To100.problems51To60.problem55;

import java.math.BigInteger;

import eulerProject.library.String2;

public class Problem55 {

	public static void main(String[] args) {
		int count = 0;
		
		for (int i=1;i<=10000;i++) {
			BigInteger num = new BigInteger(String.valueOf(i));
			BigInteger reverseNum = new BigInteger(String2.reverse(num.toString()));
			BigInteger sum = num.add(reverseNum);
			int iter=1;
			
			while (iter<=50 && !String2.isPalindrome(sum.toString())) {
				num = sum;
				reverseNum = new BigInteger(String2.reverse(num.toString()));
				sum = num.add(reverseNum);
				iter++;
			}
			
			if (!String2.isPalindrome(sum.toString())) {
				System.out.println("n:"+i+" sum:"+sum+" iterations:" + (iter-1));
				count++;
			}
		}
		
		System.out.println("count:"+count);
	}

}
