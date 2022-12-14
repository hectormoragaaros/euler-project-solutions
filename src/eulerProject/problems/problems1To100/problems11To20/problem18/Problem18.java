package eulerProject.problems.problems1To100.problems11To20.problem18;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem18 {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "triangulo15.txt";
		int[][] arrTriangular = iniciarArreglo(filename);
		
		// convierto el arreglo en un arbol binario 
		// donde cada nodo tiene 2 datos (fila, indice) (clave) y su valor
		// luego implemento un algoritmo recursivo de suma maxima de una rama, para seleccionar
		// cual es la de mayor suma.
		int suma = 0;
		
		suma=findMaxSum(arrTriangular, 0, 0);
		System.out.println("La suma máxima es:" + suma);
	}

	public static int[][] iniciarArreglo(String filename) throws FileNotFoundException {
		String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
		// calculo de n
		int n = Integer.parseInt(filename.substring(9, filename.indexOf(".txt")));

		int[][] arrTriangular = new int[n][n];
		// leo los datos del archivo
		File file = new File(userDirectory+"/src/Problems11To20/problem18/"+filename);
		Scanner sc = new Scanner(file);
		int row = 0;
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line=line.trim();
			
			if (!line.isEmpty()) {
				String[] arrStr = line.split(" ");

				for (int i = 0; i < arrStr.length; i++) {
					String numStr = arrStr[i];
					arrTriangular[row][i] = Integer.parseInt(numStr);
				}
				row++;
			}	
		}

		sc.close();
		
		return arrTriangular;
	}
	
	public static int findMaxSum(int[][] arrTriangular, int fila, int col) {
		int maxCol = fila;
		int maxFila = arrTriangular.length; // numero de filas del arreglo
		
		// casos de borde
		if (fila==maxFila-1) {
			if (col<=maxCol) {
				return arrTriangular[fila][col];
			} else {
				return 0;
			}
		} else if (fila<maxFila-1){
			if (col<=maxCol) {
				return arrTriangular[fila][col]
						+Math.max(findMaxSum(arrTriangular, fila+1, col), findMaxSum(arrTriangular, fila+1, col+1));
			} else {
				return 0;
			}
		} else {
			return 0;			
		}
	}
}
