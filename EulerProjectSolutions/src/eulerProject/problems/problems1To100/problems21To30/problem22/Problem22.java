package eulerProject.problems.problems1To100.problems21To30.problem22;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem22 {
	public static void main(String[] args) throws FileNotFoundException {
		String userDirectory = Paths.get("").toAbsolutePath().toString();
		String filename = "p022_names.txt";
		File file = new File(userDirectory + "/src/Problems21To30/problem22/" + filename);
		Scanner sc = new Scanner(file);
		long suma=0L;

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line = line.trim();
			String[] names = line.split(",");
			List<String> nombres = Arrays.stream(names).map(x -> x.replace("\"","")).collect(Collectors.toList());
			Collections.sort(nombres);
			
			for (int idx = 0;idx<nombres.size();idx++) {
				String name = nombres.get(idx);
				long puntaje = calcularPuntaje(name, idx+1);
				System.out.println(name+":"+puntaje);
				suma+=puntaje;
			}
			
			System.out.println(nombres.size());
			System.out.println("suma puntajes:" + suma);
		}
		sc.close();
	}
	
	public static long calcularPuntaje(String nombre, int lugar) {
		long suma = 0L;
				
		for (int idx=0;idx<nombre.length();idx++) {
			int val = nombre.charAt(idx)-'A'+1;
			suma+=val;
		}
		
		return suma*lugar;
	}
}
