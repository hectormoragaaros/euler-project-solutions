package eulerProject.problems.problems1To100.problems41To50.problem42;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import eulerProject.library.Math2;
import eulerProject.library.String2;

public class Problem42 {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "p042_words.txt";
		String userDirectory = Paths.get("").toAbsolutePath().toString();
		List<String> wordList = new ArrayList<>();
		int count = 0;

		File file = new File(userDirectory + "/src/Problems41To50/problem42/" + filename);

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				line = line.trim();

				if (!line.isEmpty()) {
					String[] words = line.split(",");

					wordList.addAll(Arrays.stream(words)
							.map(word -> word.replace("\"", ""))
							.collect(Collectors.toList()));
				}
			}
		}
		
		System.out.println("cantidad de palabras:" + wordList.size());
		
		for (int i = 0; i < wordList.size(); i++) {
			String word = wordList.get(i);
			int triangWordNumber = String2.getNumberOfWord(word);

			//System.out.println(word+":"+triangWordNumber);
			
			if (Math2.isTriangular(triangWordNumber)) {
				count++;
			}
		}

		System.out.println("La cantidad de palabras triangulares en el archivo es:" + count);
	}
}
