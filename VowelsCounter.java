

import java.util.*;
import java.io.*;

public class VowelsCounter {
	public static void main(String[] args) throws Exception {
		File file = new File("src/UID.java");
		if (file.exists()) {
			countVowelsAndConsonants(file);
		} else {
			System.out.println("File does not exist");
		}

	}

	public static void countVowelsAndConsonants(File file) throws Exception {
		Character[] vowelsArray = { 'A', 'E', 'O', 'U', 'I', 'a', 'e', 'o', 'u', 'i' };
		Set<Character> vowelsSet = new HashSet<Character>(Arrays.asList(vowelsArray));
		int countVowels = 0;
		int countConsonants = 0;

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int c = 0;
		while ((c = br.read()) != -1) {
			char character = (char) c;
			if (character > 'a' && character < 'z' || character > 'A' && character < 'Z') {
				if (vowelsSet.contains(character)) {
					countVowels++;
				} else {
					countConsonants++;
				}
			}

		}
		System.out.println("Vowels: " + countVowels + ", consonants:" + countConsonants);
	}
}