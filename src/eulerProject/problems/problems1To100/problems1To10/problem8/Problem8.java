package eulerProject.problems.problems1To100.problems1To10.problem8;

import java.util.Arrays;

public class Problem8 {

	public static void main(String[] args) {
		int digits = 13;
		long maxProducto = 0;
		int[] arrNumsMax = new int[digits]; 
		StringBuilder bigStr = new StringBuilder();
		
		bigStr.append("73167176531330624919225119674426574742355349194934");
		bigStr.append("96983520312774506326239578318016984801869478851843");
		bigStr.append("85861560789112949495459501737958331952853208805511");
		bigStr.append("12540698747158523863050715693290963295227443043557");
		bigStr.append("66896648950445244523161731856403098711121722383113");
		bigStr.append("62229893423380308135336276614282806444486645238749");
		bigStr.append("30358907296290491560440772390713810515859307960866");
		bigStr.append("70172427121883998797908792274921901699720888093776");
		bigStr.append("65727333001053367881220235421809751254540594752243");
		bigStr.append("52584907711670556013604839586446706324415722155397");
		bigStr.append("53697817977846174064955149290862569321978468622482");
		bigStr.append("83972241375657056057490261407972968652414535100474");
		bigStr.append("82166370484403199890008895243450658541227588666881");
		bigStr.append("16427171479924442928230863465674813919123162824586");
		bigStr.append("17866458359124566529476545682848912883142607690042");
		bigStr.append("24219022671055626321111109370544217506941658960408");
		bigStr.append("07198403850962455444362981230987879927244284909188");
		bigStr.append("84580156166097919133875499200524063689912560717606");
		bigStr.append("05886116467109405077541002256983155200055935729725");
		bigStr.append("71636269561882670428252483600823257530420752963450");
			
		final String superNumber = bigStr.toString();
		
		for (int i=0;i<superNumber.length()-digits;i++) {
			int[] numbersArray = new int[digits];

			for (int cont=0;cont<digits;cont++) {
				numbersArray[cont]=Integer.parseInt(bigStr.substring(i+cont, i+cont+1));
			}
			
			long resultado = calcularProducto(numbersArray);
			
			if (resultado>maxProducto) {
				maxProducto=resultado;
				arrNumsMax = Arrays.copyOf(numbersArray, digits);
			}
		}
		
		System.out.println("Los " + digits + " dígitos adyacentes que tienen el máximo producto son:" + Arrays.toString(arrNumsMax) + " = " + maxProducto);
	}

	private static long calcularProducto(int[] arr) {
		long resultado = 1;

		for (int i = 0; i < arr.length; i++) {
			resultado = resultado*arr[i];
		}
		
		return resultado;
	}

}
