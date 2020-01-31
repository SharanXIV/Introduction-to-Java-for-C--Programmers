import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Task2 {
	
	// Multidimensional Array to store bank data.
	// Index[x] will hold the lending bank's number.
	// Index[x][0][0] will contain first the banks balance.
	// Index[x][y] will contain banks loaned to.
		// Bank ID is in [0]
		// Loan Amount is in [1]
	static double[][][] banks;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number of banks: ");
		int noOfBanks = input.nextInt();

		System.out.print("Enter minimum limit: ");
		int minLimit = input.nextInt();

		// Assign the size of the array.
		banks = new double[noOfBanks][][];

		System.out.println("Enter information for each bank in the order below:");
		System.out.println("Bank No., Balance, Number of banks loaned to, Bank ID, Amount, etc.");

		// Loop through for each bank.
		for (int i = 0; i < banks.length; i++) {
			System.out.print("Bank #" + i + " : ");

			double balance = input.nextDouble();
			int numBanksLoaned = input.nextInt();

			// Add number of dimensions to array based on number of banks loaned to.
			// 2nd dimension is set to number of banks loaned to plus one (because [0][0]
			// will hold this bank's balance.)
			// 3rd dimension is set to 2 for bankId and loan amount and accessed using
			// the keys declared at the top of file.
			banks[i] = new double[numBanksLoaned + 1][2];

			// Set balance for this bank.
			banks[i][0][0] = balance;

			// Loop through for each bank loaned to and store amount of loan.
			// Start at 1 because 0 index contains this bank's balance only.
			for (int loanedBank = 1; loanedBank < banks[i].length; loanedBank++) {
				banks[i][loanedBank][0] = input.nextInt();
				banks[i][loanedBank][1] = input.nextDouble();
			}
		}

		// Insert line break
		System.out.println("");

		// A boolean array to store if the banks are safe or not based on minimum limit requirement.
		boolean[] unsafeIndex = auditBanks(banks, minLimit);

		// Create a dynamic integer array to hold Bank ID of unsafe banks.
		List<Integer> unsafeArray = new ArrayList<Integer>();

		// Store all unsafe banks in ArrayList and print out status of banks.
		for (int i = 0; i < unsafeIndex.length; i++) {
			if (unsafeIndex[i] == true) {
				unsafeArray.add(i);
				System.out.println("Bank #" + i + ": Unsafe");
			} else {
				System.out.println("Bank #" + i + ": Safe");
			}
		}
		
		// Insert line break
		System.out.println("");

		// Print out which banks are unsafe based on ArrayList size.
		if (unsafeArray.size() == 0) {
			System.out.println("All banks are safe");
		} else if (unsafeArray.size() == 1) {
			System.out.print("The unsafe bank is Bank #" + unsafeArray.get(0));
		} else {
			System.out.print("The unsafe banks are:");
			
			// Cycle through and print bank #s
			for (int j = 0; j < unsafeArray.size(); j++) {
				System.out.print(" Bank #" + unsafeArray.get(j));
				if (j < unsafeArray.size() - 1) {
					System.out.print(" and");
				}
			}
		}
		
		// Close scanner.
		input.close();
	}

	public static boolean[] auditBanks(double[][][] bankMatrix, int limit) {

		// Create an array of booleans with the size of the number of banks.
		boolean[] indexUnsafe = new boolean[bankMatrix.length];

		// Variable to store total balance.
		double total;

		// Flag
		boolean isSafe = false;

		while (isSafe == false) {
			isSafe = true;
			for (int banks = 0; banks < bankMatrix.length; banks++) {
				// Store total balance.
				total = bankMatrix[banks][0][0];

				// Loop through to set index and calculate total assets. Start at [1] because [0] is itself.
				for (int loanedBanks = 1; loanedBanks < bankMatrix[banks].length; loanedBanks++) {
					// Cast double to integer to set index based on bankId.
					int index = (int) bankMatrix[banks][loanedBanks][0];
					
					// If bank is safe, add amount loaned to other banks in this bank's total assets.
					// Otherwise, don't add to assets because other bank is at risk.
					if (indexUnsafe[index] == false) {
						total += bankMatrix[banks][loanedBanks][1];
					}
				}

				// Checks if assets are greater than minimum limit and has been not marked as unsafe already.
				// If assets are less than limit, flag as unsafe.
				if ((total < limit) && (indexUnsafe[banks]==false)) {
					indexUnsafe[banks] = true;
					// Reset flag to loop through all banks again.
					isSafe = false;
				}
			}
		}
		return indexUnsafe;
	}

}
