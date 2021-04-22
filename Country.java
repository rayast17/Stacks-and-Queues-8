
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {

	public static void main(String[] args) {
		Map<String, String> countryToCapitalMap = new HashMap<String, String>() {
			{
				put("Bulgaria", "Sofia");
				put("Turkey", "Istanbul");
				put("Serbia", "Belgrade");
				put("Macedonia", "Skopje");
				put("Romania", "Bucharest");
				put("Greece", "Athens");
				put("New Zealand", "Wellington");
				put("Australia", "Canberra");
			}
		};

		int points = 0;
		System.out.println("Guess the capital of the country. Only countries with one capital are included. ");
		List<String> countries = new ArrayList(countryToCapitalMap.keySet());
		Collections.shuffle(countries);
		Scanner sc = new Scanner(System.in);
		for (String country : countries) {
			System.out.println("What is the capital of " + country + "?");
			String capital = sc.nextLine();
			if (capital.equals(countryToCapitalMap.get(country))) {
				points++;
			} else {
				points--;

			}
		}
		System.out.println("Your points are " + points + ".");
	}
}