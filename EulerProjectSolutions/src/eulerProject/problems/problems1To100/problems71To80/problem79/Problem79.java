package eulerProject.problems.problems1To100.problems71To80.problem79;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import eulerProject.library.String2;

public class Problem79 {

	public static void main(String[] args) throws FileNotFoundException {
		Set<Integer> set = new HashSet<>();
		String strNum = "";

		String filename = "p079_keylog.txt";
		String userDirectory = Paths.get("").toAbsolutePath().toString();
		File file = new File(userDirectory + "/src/Problems71To80/problem79/" + filename);

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				line = line.trim();

				if (!line.isEmpty()) {
					set.add(Integer.parseInt(line));
				}
			}
		}
		System.out.println(set.toString());

		for (Integer num : set) {
			if (strNum.isEmpty()) {
				strNum = String.valueOf(num);
			} else {
				int code = revisarCode(strNum, num);
				String primero = String.valueOf(num).substring(0, 1);
				String segundo = String.valueOf(num).substring(1, 2);
				String tercero = String.valueOf(num).substring(2);
				int idx0 = -1;
				int idx1 = -1;
				int idx2 = -1;

				switch (code) {
				case 0:
					strNum = strNum.concat(String.valueOf(num));
					break;
				case 1: // el ultimo existe
					idx0 = strNum.indexOf(String.valueOf(tercero));

					if (idx0 == 0) {//agrego el primero y el segundo al inicio
						strNum = String2.insert(strNum, idx0, segundo);
						strNum = String2.insert(strNum, idx0, primero);
					} else {
						strNum = String2.insert(strNum, idx0, primero.concat(segundo));
					}
					break;
				case 2: // el del medio existe
					idx1 = strNum.indexOf(String.valueOf(segundo));

					if (idx1 == 0) {
						strNum = String2.insert(strNum.substring(idx1+1), idx1, String.valueOf(num));
					} else if (idx1== strNum.length()-1){
						strNum = strNum.substring(0,idx1).concat(String.valueOf(num));
					} else {
						strNum = strNum.substring(0, idx1).concat(String.valueOf(num)).concat(strNum.substring(idx1+1));
					}
					break;
				case 3: // existe el del medio y el ultimo
					idx1 = strNum.indexOf(String.valueOf(segundo));
					idx0 = strNum.indexOf(String.valueOf(tercero));

					// orden es incorrecto, por lo que se deben intercambiar los elementos
					if (idx1 > idx0) {
						strNum = String2.swapElements(strNum, idx0, idx1);
						// se debe ingresar el primer elemento
						strNum = String2.insert(strNum, idx0-1, primero);
					} else {
						// orden correcto pero debe insertarse el primer elemento antes del segundo
						strNum = String2.insert(strNum, idx1-1, primero);
					}
					break;
				case 4: // existe el primer elemento
					idx2 = strNum.indexOf(String.valueOf(primero));

					if (idx2 == 0) {
						strNum = String2.insert(strNum.substring(idx2+1), idx2, String.valueOf(num));
					} else if (idx2 == strNum.length() - 1) {
						strNum = String2.insert(strNum, idx2+1, segundo.concat(tercero));
					} else {
						strNum = String2.insert(strNum, idx2, String.valueOf(num));
					}
					break;
				case 5: // existen el primero y el tercero
					idx2 = strNum.indexOf(String.valueOf(primero));
					idx0 = strNum.indexOf(String.valueOf(tercero));

					if (idx2 > idx0) {
						// orden incorrecto
						strNum = String2.swapElements(strNum, idx0, idx2);
						// se ingresa el segundo, antes del tercero
						strNum = String2.insert(strNum, idx2-1, segundo);
					} else {
						// orden correcto, pero se debe insertar el segundo, despues del primero
						strNum = String2.insert(strNum, idx2+2, segundo);
					}
					break;
				case 6: // existen el primero y el segundo
					idx2 = strNum.indexOf(String.valueOf(primero));
					idx1 = strNum.indexOf(String.valueOf(segundo));

					if (idx2 > idx1) {
						// orden incorrecto
						strNum = String2.swapElements(strNum, idx2, idx1);
						// se ingresa el tercer elemento despues del segundo
						strNum = String2.insert(strNum, idx2+1, tercero);
					} else {
						// orden correcto, insertar el tercero despues del segundo
						strNum = String2.insert(strNum, idx1+1, tercero);
					}
					break;
				case 7: // existen los 3
					idx2 = strNum.indexOf(String.valueOf(primero));
					idx1 = strNum.indexOf(String.valueOf(segundo));
					idx0 = strNum.indexOf(String.valueOf(tercero));

					// solo se hace algo si alguno de los indices no está ordenado
					if ((idx2 < idx0) && (idx0 < idx1)) { // incorrectos el segundo y el tercero
						strNum = String2.swapElements(strNum, idx1, idx0);
					} else if ((idx1 < idx2) && (idx2 < idx0)) { // incorrectos el primero y el segundo
						strNum = String2.swapElements(strNum, idx2, idx1);
					} else if ((idx1 < idx0) && (idx0 < idx2)) { // todos incorrectos, se mueve el idx2 delante del idx1
						strNum = String2.move(strNum, idx2, idx0); // intercambio entre el tercero y el primero
						strNum = String2.swapElements(strNum, idx1, idx0); // intercambio entre el segundo y el primero
					} else if ((idx0 < idx1) && (idx1 < idx2)) { // incorrectos el primero y el tercero
						strNum = String2.swapElements(strNum, idx2, idx0); 
					} else if ((idx0 < idx2) && (idx2 < idx1)) { // todos incorrectos, se mueve idx0 detras de idx1
						strNum = String2.move(strNum, idx2, idx0);
					}
					break;
				default:
					break;
				}
			}
		}
		System.out.println("El minimo codigo correcto es:" + strNum);
	}

	private static int revisarCode(String strNum, Integer num) {
		String x = String.valueOf(num);
		int count = 0;
		int res = 1;

		for (int i = x.length() - 1; i >= 0; i--) {
			String digit = x.substring(i, i + 1);

			if (strNum.contains(digit)) {
				count += res;
			}
			res = res << 1;
		}

		return count;
	}
}
