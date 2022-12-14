package eulerProject.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Math2 {
	private Math2() {
	}

	public static List<Integer> divisoresSinElPropioNumero(int num) {
		Set<Integer> resultado = new HashSet<>();
		Set<Integer> aux = new HashSet<>();

		for (int i = 2; i < (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				resultado.add(i);
			}
		}

		for (Integer divisor : resultado) {
			aux.add(num / divisor);
		}
		resultado.addAll(aux);
		resultado.add(1);

		return new ArrayList<>(resultado);
	}

	public static List<Long> divisores(long num) {
		Set<Long> respuesta = new HashSet<>();

		for (long i = 2L; i <= (long) Math.sqrt(num); i++) {
			if (num % i == 0) {
				respuesta.add(i);
				respuesta.add(num / i);
			}
		}

		// 1 y el numero siempre son divisores
		respuesta.add(1L);
		respuesta.add(num);

		return new ArrayList<>(respuesta);
	}

	public static List<Long> divisoresSinElPropioNumero(long num) {
		Set<Long> resultado = new HashSet<>();
		Set<Long> aux = new HashSet<>();

		for (long i = 2L; i < (long) Math.sqrt(num); i++) {
			if (num % i == 0) {
				resultado.add(i);
			}
		}

		for (Long divisor : resultado) {
			aux.add(num / divisor);
		}
		resultado.addAll(aux);
		resultado.add(1L);

		return new ArrayList<>(resultado);
	}

	public static List<Integer> divisores(int num) {
		Set<Integer> respuesta = new HashSet<>();

		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				respuesta.add(i);
				respuesta.add(num / i);
			}
		}

		// 1 y el numero siempre son divisores
		respuesta.add(1);
		respuesta.add(num);

		return new ArrayList<>(respuesta);
	}

	public static BigInteger factorial(BigInteger n) {
		if (n.longValue() <= 1L) {
			return BigInteger.ONE;
		} else {
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
		}
	}

	public static long factorial(long n) {
		if (n <= 1) {
			return 1L;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int gcd(int n1, int n2) {
		return (n2 != 0) ? gcd(n2, n1 % n2) : n1;
	}

	public static List<Pair<Long>> primeFactors(Long n) {
		List<Pair<Long>> result = new ArrayList<>();
		long x = n;

		for (long i = 2L; i <= Math.round(Math.sqrt(n))|| x!=1L; i++) {
			if (isPrime(i) && (x % i == 0)) {
				long count = 0;
				do {
					count++;
					x /= i;
				} while (x % i == 0);
				result.add(new Pair<>(i, count));
			}
		}
		
		// si el numero buscado es primo (y n se puede factorizar)
		if (result.isEmpty()) {
			result.add(new Pair<>(x, 1L));
		}

		return result;
	}

	/**
	 * https://stackoverflow.com/questions/4407839/how-can-i-find-the-square-root-of-a-java-biginteger
	 * @param x
	 * @return
	 */
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}	
	
	public static List<Pair<BigInteger>> primeFactors(BigInteger n) {
		List<Pair<BigInteger>> result = new ArrayList<>();
		BigInteger x = n;

		for (BigInteger i = BigInteger.valueOf(2L); i.compareTo(sqrt(n))<=0 || x!=BigInteger.ONE; i.add(BigInteger.ONE)) {
			if (isPrime(i) && (x.mod(i).compareTo(BigInteger.ZERO) == 0)) {
				long count = 0;
				do {
					count++;
					x=x.divide(i);
				} while (x.mod(i).compareTo(BigInteger.ZERO) == 0);
				result.add(new Pair<>(i, BigInteger.valueOf(count)));
			}
		}
		
		// si el numero buscado es primo (y n se puede factorizar)
		if (result.isEmpty()) {
			result.add(new Pair<>(x, BigInteger.ONE));
		}

		return result;
	}
	
	
	public static List<Long> getPrimeFactors(Long n1) {
		Set<Long> set = new LinkedHashSet<>();

		long x = n1;

		while (x != 1L) {
			for (long i = 2L; i <= x; i++) {
				boolean esPrimo = Math2.isPrime(i);
				if (esPrimo && (x % i == 0)) {
					set.add(i);
					x = x / i;
					break;
				}
			}
		}

		return new ArrayList<>(set);
	}

	public static boolean isAbundante(Number num) {
		if (num instanceof Integer) {
			int nx = num.intValue();
			List<Integer> divisores = divisoresSinElPropioNumero(nx);
			divisores.add(nx);

			return (divisores.stream().reduce(0, Integer::sum) > nx);
		} else if (num instanceof Long) {
			long nx = num.longValue();
			List<Long> divisores = divisoresSinElPropioNumero(nx);
			divisores.add(nx);

			return (divisores.stream().reduce(0L, Long::sum) > nx);
		} else {
			return false;
		}
	}

	public static boolean isCircularPrime(int num) {
		// genero los circulares del numero
		if (String.valueOf(num).length() > 0) {
			String[] numStrs = String2.rotaciones(String.valueOf(num));
			// System.out.println(Arrays.toString(numStrs));

			for (String numStr : numStrs) {
				boolean eval = Math2.isPrime(Integer.parseInt(numStr));
				if (!eval) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isNumeroPerfecto(Number num) {
		if (num instanceof Integer) {
			int nx = num.intValue();
			List<Integer> divisores = divisoresSinElPropioNumero(nx);
			divisores.add(nx);

			return (divisores.stream().reduce(0, Integer::sum) == nx);
		} else if (num instanceof Long) {
			long nx = num.longValue();
			List<Long> divisores = divisoresSinElPropioNumero(nx);
			divisores.add(nx);

			return (divisores.stream().reduce(0L, Long::sum) == nx);
		} else {
			return false;
		}
	}

	// se valida primero si n es primo
	public static boolean isTruncablePrime(int n) {
		if (!Math2.isPrime(n)) {
			return false;
		}
		String str = String.valueOf(n);

		// se trunca de izq a derecha
		for (int i = 0; i < str.length(); i++) {
			Integer num = Integer.parseInt(str.substring(i));
			if (!Math2.isPrime(num)) {
				return false;
			}
		}

		// se trunca de derecha a izq
		for (int i = str.length(); i > 0; i--) {
			Integer num = Integer.parseInt(str.substring(0, i));
			if (!Math2.isPrime(num)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPrime(Number n) {
		if (n instanceof Integer) {
			Integer nx = n.intValue();

			if (nx > 1) {
				for (int i = 2; i <= (int) Math.sqrt(nx); i++) {
					if (nx % i == 0) {
						return false;
					}
				}
			} else {
				return false;
			}
		} else if (n instanceof Long) {
			Long nx = n.longValue();

			if (nx > 1) {
				for (long i = 2L; i <= (long) Math.sqrt(nx); i++) {
					if (nx % i == 0) {
						return false;
					}
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

		return true;
	}

	public static long triangular(long n) {
		return n * (n + 1) / 2;
	}

	public static boolean isTriangular(int triangWordNumber) {
		if (triangWordNumber <= 0) {
			return false;
		} else {
			int n = 0;
			int tri = n * (n + 1) / 2;

			while (tri < triangWordNumber) {
				n++;
				tri = n * (n + 1) / 2;
			}

			return (tri == triangWordNumber);
		}
	}

	// From: https://www.baeldung.com/java-find-if-square-root-is-integer
	public static boolean isPerfectSquareWithOptimization(long n) {
		if (n < 0) {
			return false;
		}
		switch ((int) (n & 0xF)) {
		case 0:
		case 1:
		case 4:
		case 9:
			long tst = (long) Math.sqrt(n);
			return tst * tst == n;
		default:
			return false;
		}
	}

	public static Long pentagonal(long n) {
		return n * (3 * n - 1) / 2;
	}

	public static Long hexagonal(long n) {
		return n * (2 * n - 1);
	}

	public static double productoPunto(int[] coins, int[] coinValues) {
		int suma = 0;

		for (int i = 0; i < coins.length; i++) {
			suma += (coins[i] * coinValues[i]);
		}

		return suma;
	}

	public static boolean containsSameDigits(Number x) {
		if (x instanceof Integer) {
			int ix = (int) x;

			return (String2.containsSameDigits(String.valueOf(ix), String.valueOf(2 * ix))
					&& String2.containsSameDigits(String.valueOf(ix), String.valueOf(3 * ix))
					&& String2.containsSameDigits(String.valueOf(ix), String.valueOf(4 * ix))
					&& String2.containsSameDigits(String.valueOf(ix), String.valueOf(5 * ix))
					&& String2.containsSameDigits(String.valueOf(ix), String.valueOf(6 * ix)));
		} else if (x instanceof Long) {
			long lx = (long) x;

			return (String2.containsSameDigits(String.valueOf(lx), String.valueOf(2 * lx))
					&& String2.containsSameDigits(String.valueOf(lx), String.valueOf(3 * lx))
					&& String2.containsSameDigits(String.valueOf(lx), String.valueOf(4 * lx))
					&& String2.containsSameDigits(String.valueOf(lx), String.valueOf(5 * lx))
					&& String2.containsSameDigits(String.valueOf(lx), String.valueOf(6 * lx)));
		} else
			return false;
	}

	public static BigInteger combinatoria(long n, long r) {
		return factorial(BigInteger.valueOf(n))
				.divide(factorial(BigInteger.valueOf(n - r)).multiply(factorial(BigInteger.valueOf(r))));
	}

	public static long sumaDigitos(BigInteger bigInt) {
		long suma = 0;
		String strNum = bigInt.toString();

		for (int i = 0; i < strNum.length(); i++) {
			suma += Integer.parseInt(strNum.substring(i, i + 1));
		}

		return suma;
	}

	public static List<Integer> listaPrimos(int n) {
		List<Integer> result = new ArrayList<>();

		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				result.add(i);
			}
		}

		return result;
	}
}
