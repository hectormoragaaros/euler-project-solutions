package eulerProject.problems.problems601To700.problems691To700.problem700;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem700 {

	public static void main(String[] args) {
		BigInteger n = BigInteger.valueOf(4503599627370517L);
		BigInteger a = BigInteger.valueOf(1504170715041707L);
		List<BigInteger> parciales = new ArrayList<>();

		// se encuentran los primeros 16 rapidamente
		for (long i=1L;parciales.size()<=16;i++) {
			BigInteger x = BigInteger.valueOf(i);
			BigInteger mult = a.multiply(x).mod(n);
			
			if (esMenor(mult, parciales)) {
				if (!parciales.isEmpty()) {
					parciales.add(0, mult);					
				} else {
					parciales.add(mult);
				}
				System.out.println(parciales.toString());
			}
		}

		// se revisa la "cola" de los elementos que falta buscar
		BigInteger aInv = a.modInverse(n);
		System.out.println(aInv);

		do {
			BigInteger limit = BigInteger.valueOf(parciales.get(0).longValue());

			for (BigInteger Nn=limit;Nn.compareTo(BigInteger.ONE)>0;Nn=Nn.subtract(BigInteger.ONE)) {
				BigInteger x = Nn.multiply(aInv).mod(n);
				if (esMenor(x, parciales)) {
					parciales.add(0, x);
					System.out.println(parciales.toString());
				}
			}
		} while (parciales.get(0).longValue()>1);
		
		System.out.println(parciales.toString());
		System.out.println(parciales.stream().reduce(BigInteger.ZERO, BigInteger::add).toString());
	}

	private static boolean esMenor(BigInteger b, List<BigInteger> parciales) {
		if (parciales.size()>0) {
			for (int idx=parciales.size()-1;idx>=0;idx--) {
				if (b.compareTo(parciales.get(idx))>=0) {
					return false;
				}
			}			
		}

		return true;
	}
}
