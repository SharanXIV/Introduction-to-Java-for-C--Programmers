// JAC444 - Workshop 1 
// Filename:     LuhnCheck.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-09-19

import java.util.Scanner;

public class LuhnCheck {
	// Used because Eclipse warning for not closing Scanner.
	@SuppressWarnings("resource")
	
	// Main method, will implement in tester class in future.
	public static void main(String[] args) {
		luhnChecker();
	}
	
	// Credit Card Validation method.
	public static void luhnChecker() {
		System.out.println("Please enter a 13-16 digit credit card number: ");
		Scanner cardNum = new Scanner(System.in);
		
		if (cardNum.hasNextLong()) {
			long cardLong = cardNum.nextLong();
			if (isValid(cardLong)) {
				System.out.println("The card number: " + cardLong + " is valid.");
			} else {
				System.out.println("The card number: " + cardLong + " is not valid.");
			}
		} else {
			System.out.println("Error! Your entry: '" + cardNum.nextLine() + "' is not numeric.");
		}
	}
	
	// Returns 'true' if the card number is valid.
	public static boolean isValid(long number) {
		boolean valid = false;
		int noOfDigits = getSize(number);

		if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37)
				|| prefixMatched(number, 6)) {
			if (13 <= noOfDigits && noOfDigits <= 16) {
				if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
					valid = true;
				} else {
					valid = false;
					System.out.println("Error: " + number + " does not pass the Luhn check.");
				}
			} else {
				valid = false;
				System.out.println("Error: " + number + " is not between 13 and 16 digits.");
			}
		} else {
			valid = false;
			System.out.println("Error: " + number + " does not start with 4, 5, 6, or 37.");
		}

		return valid;
	}

	// Sum of doubled even place digits from 'number'.
	// Converts 'number' to a string and a descending for loop to find even digits
	// then invokes 'getDigit' method to ensure a single digit number.
	public static int sumOfDoubleEvenPlace(long number) {
		String digitsString = Long.toString(number);
		int sum = 0;

		for (int i = (digitsString.length() - 2); i >= 0; i -= 2) {
			char temp = digitsString.charAt(i);
			int tempInt = (Character.getNumericValue(temp)) * 2;
			sum += getDigit(tempInt);
		}

		return sum;
	}

	// Returns 'number' if it is a single digit, otherwise, returns the sum of the two digits.
	// Converts 'number' to a string to find the length and find the sum of specific digits.
	public static int getDigit(int number) {
		String numberString = Integer.toString(number);
		int length = numberString.length();
		int total = 0;

		if (length > 1) {
			total = (Character.getNumericValue(numberString.charAt(0))
					+ Character.getNumericValue(numberString.charAt(1)));
			return total;
		} else {
			return number;
		}
	}

	// Returns sum of odd-place digits in 'number'.
	public static int sumOfOddPlace(long number) {
		String digitsString = Long.toString(number);
		int sum = 0;

		for (int i = (digitsString.length() - 1); i >= 0; i -= 2) {
			char temp = digitsString.charAt(i);
			int tempInt = (Character.getNumericValue(temp));
			sum += getDigit(tempInt);
		}

		return sum;
	}
 
	// Returns 'true' if the digit 'd' is a prefix for 'number'.
	public static boolean prefixMatched(long number, int d) {
		long prefix = getPrefix(number, Integer.toString(d).length());

		if (prefix == d) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the number of digits in 'd'.
	public static int getSize(long d) {
		return Long.toString(d).length();
	}

	// Returns the first 'k' number of digits from 'number'. If the number 
	// of digits in 'number' is less than 'k', returns 'number'.
	public static long getPrefix(long number, int k) {
		String numberString = Long.toString(number);
		numberString = numberString.substring(0, k);
		int prefix = Integer.valueOf(numberString);
		return prefix;
	}
}
