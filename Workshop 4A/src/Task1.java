// JAC444 - Workshop 4 - Task 1
// Filename:     Task1.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-10-18

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
	char phoneDial[][] = { //{ '0' }, { '1' },			// We do not store numbers 0 and 1.
							{ 'A', 'B', 'C' },			// For number 2
							{ 'D', 'E', 'F' },			// For number 3
							{ 'G', 'H', 'I' },			// For number 4
							{ 'J', 'K', 'L' },			// For number 5
							{ 'M', 'N', 'O' },			// For number 6
							{ 'P', 'Q', 'R', 'S' },		// For number 7
							{ 'T', 'U', 'V' },			// For number 8
							{ 'W', 'X', 'Y', 'Z' } };  	// For number 9

	char[][] letters = new char[7][];					// Stores letters used by user entered number.
	
	// This method prompts the user to enter a seven digit phone number.
	public void getInput() throws IOException {
		System.out.println("Please enter a seven digit phone number, do not use 0 or 1 (#######): ");
		Scanner input = new Scanner(System.in);
		
		// Check if entry is 7 digits in length and contains only numbers.
		if (input.hasNextInt()) {
			String phoneNum = input.nextLine();
			if (phoneNum.length()==7) {
				convertToLetters(phoneNum);
			}
			else {
				System.out.println("Error! Not seven digits!");
			}
		}
		else {
			System.out.println("Error! Not a phone number!");
		}
	}

	// This method will convert the phone number entered into a combination of words.
	public void convertToLetters(String phoneNum) throws IOException {
		
	    BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

		for (int i = 0; i < phoneNum.length(); i++) {
			
			// Will parse integer from string digit by digit and set as index.
			// We subtract 2 from index because we are not using 0 or 1.
			int index = Integer.parseInt(phoneNum.substring(i, i + 1)) - 2;	
			
			// Check if user has entered 0 or 1.
			if (index < 0) {
				System.out.println("Error! You have entered 0 or 1!");
				System.exit(0);
			}
			
			// Copy available letters from phoneDial for that integer.
			letters[i] = phoneDial[index];									
		}
		
		String combinations = "";
		
		int counter = 0;
		
		// Nested for loop to cycle through each combination of letters.
		for (int l1 = 0; l1 < letters[0].length; l1++) {
			for (int l2 = 0; l2 < letters[1].length; l2++) {
				for (int l3 = 0; l3 < letters[2].length; l3++) {
					for (int l4 = 0; l4 < letters[3].length; l4++) {
						for (int l5 = 0; l5 < letters[4].length; l5++) {
							for (int l6 = 0; l6 < letters[5].length; l6++) {
								for (int l7 = 0; l7 < letters[6].length; l7++) {
									combinations = String.valueOf(letters[0][l1]);
									combinations += String.valueOf(letters[1][l2]);
									combinations += String.valueOf(letters[2][l3]);
									combinations += String.valueOf(letters[3][l4]);
									combinations += String.valueOf(letters[4][l5]);
									combinations += String.valueOf(letters[5][l6]);
									combinations += String.valueOf(letters[6][l7]);
									
									counter++;
									// Write this combination to the file.
								    bw.write(combinations);
								    bw.write('\n');
								}	
							}	
						}	
					}	
				}	
			}			
		}
		
		System.out.println(counter + " lines printed.");
		
		// Flushing and closing the output file writer.
	    bw.flush();
	    bw.close();
	}
	
	
}
