package eulerProject.problems.problems1To100.problems41To50.problem44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import eulerProject.library.Math2;
import eulerProject.library.Pair;

public class Problem44 {

	public static void main(String[] args) {
		List<Pair<Long>> lista = new ArrayList<>();
		int num=10000;
		
		List<Long> pentagonalList = Arrays.stream(LongStream.range(1, num).map(Math2::pentagonal).toArray()).boxed().collect(Collectors.toList());
		
		for (int k=0;k<pentagonalList.size();k++) {
			long pk = pentagonalList.get(k);
			for (int j=0;j<pentagonalList.size();j++) {
				long pj = pentagonalList.get(j);
				long suma = pj+pk;
				long resta = Math.abs(pk-pj);
				
				if (pentagonalList.contains(suma) &&
						pentagonalList.contains(resta)) {
					lista.add(new Pair<>(pj, pk));
					System.out.println("pj:"+pj+" pk:"+pk);
				}
			}
		}		
	}
}
