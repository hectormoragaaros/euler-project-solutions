package eulerProject.problems.problems1To100.problems31To40.problem39;

import java.util.HashSet;
import java.util.Set;

import eulerProject.library.Triplet;

public class Problem39 {

	public static void main(String[] args) throws Exception {
		int maxP = -1;
		int maxTriplets = -1;

		for (int p = 1; p <= 1000; p++) {
			Set<Triplet<Integer>> setTripletas = new HashSet<>();

			for (int a = 1; a < p; a++) {
				for (int b = 1; b < p; b++) {
					int c = p - a - b;

					if ((c > 0) && (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2) == 0)) {
						Triplet<Integer> tri = new Triplet<>(a, b, c);
						setTripletas.add(tri);
					}
				}
			}

			if (setTripletas.size() > maxTriplets) {
				maxP = p;
				maxTriplets = setTripletas.size();
			}
		}

		System.out.println(
				"La mayor cantidad de soluciones se da con p=" + maxP + " y son " + maxTriplets + " soluciones");
	}
}
