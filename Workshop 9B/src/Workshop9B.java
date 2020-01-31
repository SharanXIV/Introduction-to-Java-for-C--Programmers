// JAC444 - Workshop 9 - Task 2
// Filename:     Workshop9B.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-29

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Workshop9B {

	public static void main(String[] args) {
		Map<String, String> countryCapitalsMap = new HashMap<>(50);

		for (String[] countryCapital : capitals) {
			countryCapitalsMap.put(countryCapital[0], countryCapital[1]);
		}

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a country: ");
		String userCountry = input.nextLine();

		countryCapitalsMap.forEach((country, city) -> {
			if (userCountry.equalsIgnoreCase(country)) {
				System.out.println("The capital is " + city + ".");
			}
		});
	}

	private static String[][] capitals = { { "China", "Beijing" }, { "Japan", "Tokyo" }, { "Russia", "Moscow" },
			{ "Indonesia", "Jakarta" }, { "South Korea", "Seoul" }, { "Egypt", "Cairo" }, { "Mexico", "Mexico City" },
			{ "Bangladesh", "Dhaka" }, { "England", "London" }, { "Peru", "Lima" }, { "Iran", "Tehran" },
			{ "Thailand", "Bangkok" }, { "Vietnam", "Hanoi" }, { "Saudi Arabia", "Riyadh" }, { "Columbia", "Bogotá" },
			{ "Iraq", "Baghdad" }, { "Chile", "Santiago" }, { "Turkey", "Ankara" }, { "Germany", "Berlin" },
			{ "Syria", "Damascus" }, { "Algeria", "Algiers" }, { "Spain", "Madrid" }, { "North Korea", "Pyongyang" },
			{ "Afghanistan", "Kabul" }, { "Kenya", "Nairobi" }, { "Italy", "Rome" } };
}
