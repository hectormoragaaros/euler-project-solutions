package eulerProject.problems.problems1To100.problems61To70.problem67;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem67 {
	// la estrategia publicada en https://rosettacode.org/wiki/Maximum_triangle_path_sum#Java
    // consiste en partir desde la ultima fila e ir sumando a las celdas de la fila anterior
	// el valor maximo entre los 2 caminos que puede tener, de manera que con este algoritmo
	//botom-up se van cercenando las rutas que no tienen la suma máxima.
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "p067_triangle.txt";
		int[][] arrTriangular = iniciarArreglo(filename);		

	    for (int r = arrTriangular.length - 1; r > 0; r--)
            for (int c = 0; c < arrTriangular[r].length - 1; c++)
            	arrTriangular[r - 1][c] += Math.max(arrTriangular[r][c], arrTriangular[r][c + 1]);

        System.out.println(arrTriangular[0][0]);
	}
	
	public static int[][] iniciarArreglo(String filename) throws FileNotFoundException {
		String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();

		int n = 100;

		int[][] arrTriangular = new int[n][n];
		// leo los datos del archivo
		File file = new File(userDirectory+"/src/Problems61To70/problem67/"+filename);
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
}
