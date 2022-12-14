package eulerProject.problems.problems1To100.problems21To30.problem24;

import java.util.Collections;
import java.util.List;

import eulerProject.library.String2;

public class Problem24 {

	public static void main(String[] args) {
		List<String> res = String2.permutaciones("0123456789");
		Collections.sort(res);
		
		System.out.println(res.get(1000000-1));
	}
}
