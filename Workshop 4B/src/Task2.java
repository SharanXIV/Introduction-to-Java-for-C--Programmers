// JAC444 - Workshop 4 - Task 2
// Filename:     Task2.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-10-18

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
	
	// Both arrays are parallel but hold different data types.
	char alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	int charCount[] = new int[alphabet.length];

	void getOccurances() throws IOException {
		System.out.println("Please enter the name of the file: ");
		Scanner input = new Scanner(System.in);
		String userFileName = input.nextLine();
		
		File file = new File(userFileName); 
		
		// Check if the file exists in project folder.
		if (!file.exists()) {
			System.out.println("File does not exist.");
			System.exit(0);
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file));


		int i;
		
		// Read file until EOF (If the end of the stream has been reached the method returns -1).
		// Goes through stream, character by character.
		while ((i = br.read()) != -1) {
			// Loop through for each letter in alphabet.
			for (int j = 0; j < alphabet.length; j++) {
				// Cast integer to character.
				char letter = (char)i;
				
				// If letter in alphabet array matches character in stream, increment character count.
				if (alphabet[j] == letter) {
					charCount[j]++;
				}
			}
		}

		for (int x = 0; x < alphabet.length; x++) {
			System.out.print("Number of " + alphabet[x] + "\'s: " + charCount[x] + "\n");
		}

		// Close Buffered Reader.
		br.close();

	}

}
