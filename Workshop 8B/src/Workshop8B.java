// JAC444 - Workshop 8B 
// Filename:     Workshop8B.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-21

import java.util.Scanner;

public class Workshop8B {
	// Creates the grid for the game.
	public static String[][] createGrid() {
		// 2D Array that holds strings, 7 down and 15 across.

		// Grid Reference Table
		// [ ][0][0][0][0][0][0][0][0][0][0][1][1][1][1][1]
		// [ ][0][1][2][3][4][5][6][7][8][9][0][1][2][3][4]
		// [0][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [1][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [2][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [3][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [4][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [5][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|][ ][|]
		// [6][-][-][-][-][-][-][-][-][-][-][-][-][-][-][-]

		String[][] grid = new String[7][15];

		// Loops over each row
		for (int i = 0; i < grid.length; i++) {
			// Loops over each column
			for (int j = 0; j < grid[i].length; j++) {
				// Every other element will be a line followed by blank.
				if (j % 2 == 0)
					grid[i][j] = "|";
				else
					grid[i][j] = " ";
				// Last row is filled with '-' to create base.
				if (i == 6)
					grid[i][j] = "-";
			}
		}
		return grid;
	}

	// Prints the grid on the console.
	public static void printGrid(String[][] grid) {
		// Loops over each row
		for (int i = 0; i < grid.length; i++) {
			// Loops over each column
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	// Allows the user to enter a column to drop red piece to bottom available row of that column.
	public static void redTurn(String[][] grid) {
		System.out.println("Drop a red disk at column (0 – 6): ");
		Scanner input = new Scanner(System.in);
		
		// Error handling.
		int entry = input.nextInt();
		if (entry > 6) {
			System.out.println("That is an invalid column.");
			System.exit(0);
		}

		// User will enter a column but we have to convert it into our column dimensions.
		// E.g. User enters column 3, in our grid it is column 7.
		int userColumn = (entry*2) + 1;

		// Loop from bottom to check if slot is empty for column, if so fill with 'R'.
		for (int i = 5; i >= 0; i--) {
			if (grid[i][userColumn] == " ") {
				grid[i][userColumn] = "R";
				break;
			}

		}
	}

	// Allows the user to enter a column to drop yellow piece to bottom available row of that column.
	public static void yellowTurn(String[][] grid) {
		System.out.println("Drop a yellow disk at column (0 – 6): ");
		Scanner input = new Scanner(System.in);

		// Error handling.
		int entry = input.nextInt();
		if (entry > 6) {
			System.out.println("That is an invalid column.");
			System.exit(0);
		}
		
		// User will enter a column but we have to convert it into our column dimensions.
		// E.g. User enters column 3, in our grid it is column 7.
		int userColumn = (entry*2) + 1;
		
		// Loop from bottom to check if slot is empty for column, if so fill with 'Y'.
		for (int i = 5; i >= 0; i--) {
			if (grid[i][userColumn] == " ") {
				grid[i][userColumn] = "Y";
				break;
			}

		}
	}

	// Checks whether the grid has a string of four R's or Y's that can be
	// horizontal, vertical or diagonally.
	public static String checkWin(String[][] grid) {
		// Check for horizontal winner.
		// Loop over each row.
		for (int i = 0; i < 6; i++) {
			// Win can only happen if conditions are met:
			//	1. [x][x][x][x][ ][ ]
			//  2. [ ][x][x][x][x][ ]
			//  3. [ ][ ][x][x][x][x]
			
			// Loop within row, and check each column for win condition.
			for (int j = 0; j < 7; j += 2) {
				if ((grid[i][j + 1] != " ") && (grid[i][j + 3] != " ") && (grid[i][j + 5] != " ") && (grid[i][j + 7] != " ")
						&& ((grid[i][j + 1] == grid[i][j + 3])
						&& (grid[i][j + 3] == grid[i][j + 5])
						&& (grid[i][j + 5] == grid[i][j + 7]))) {
					// Return either 'R' or 'Y' for the winner.
					return grid[i][j + 1];
				}
			}
		}

		// Check for vertical winner.
		// Loop over each row.
		for (int i = 1; i < 15; i += 2) {
			// Win can only happen if conditions are met:
			//	1. [x]   2. [ ]   3. [ ]
			//     [x]      [x]      [ ]
			//     [x]      [x]      [x]
			//	   [x]      [x]      [x]
			//     [ ]      [x]      [x]
			//     [ ]      [ ]      [x]
			
			// Loop within column, and check each row for win condition.
			for (int j = 0; j < 3; j++) {
				if ((grid[j][i] != " ") && (grid[j + 1][i] != " ") && (grid[j + 2][i] != " ") && (grid[j + 3][i] != " ")
						&& ((grid[j][i] == grid[j + 1][i])
						&& (grid[j + 1][i] == grid[j + 2][i])
						&& (grid[j + 2][i] == grid[j + 3][i]))) {
					// Return either 'R' or 'Y' for the winner.
					return grid[j][i];
				}
			}
		}

		// Check for diagonal winner, from left to right.
		// Loops the first 3 rows (can't have four diagonally starting from row 4)
		for (int i = 0; i < 3; i++) {
			// Win can only happen if conditions are met:
			// Four in a row found diagonally within 'x'.
			// [x][x][x][x][ ][ ][ ]
			// [x][x][x][x][x][ ][ ]
			// [x][x][x][x][x][x][ ]
			// [ ][x][x][x][x][x][x]
			// [ ][ ][x][x][x][x][x]
			// [ ][ ][ ][x][x][x][x]

			for (int j = 1; j < 9; j += 2) {
				if ((grid[i][j] != " ") && (grid[i + 1][j + 2] != " ") && (grid[i + 2][j + 4] != " ") && (grid[i + 3][j + 6] != " ")
						&& ((grid[i][j] == grid[i + 1][j + 2])
						&& (grid[i + 1][j + 2] == grid[i + 2][j + 4])
						&& (grid[i + 2][j + 4] == grid[i + 3][j + 6]))) {
					return grid[i][j];
				}
			}
		}

		// Check for diagonal winner, from right to left.
		// Loops the first 3 rows (can't have four diagonally starting from row 4)
		for (int i = 0; i < 3; i++) {
			// Win can only happen if conditions are met:
			// Four in a row found diagonally within 'x'.
			// [ ][ ][ ][x][x][x][x]
			// [ ][ ][x][x][x][x][x]
			// [ ][x][x][x][x][x][x]
			// [x][x][x][x][x][x][ ]
			// [x][x][x][x][x][ ][ ]
			// [x][x][x][x][ ][ ][ ]
			
			// Reverse of previous for loop.
			for (int j = 7; j < 15; j += 2) {
				if ((grid[i][j] != " ") && (grid[i + 1][j - 2] != " ") && (grid[i + 2][j - 4] != " ") && (grid[i + 3][j - 6] != " ")
						&& ((grid[i][j] == grid[i + 1][j - 2]) 
						&& (grid[i + 1][j - 2] == grid[i + 2][j - 4])
						&& (grid[i + 2][j - 4] == grid[i + 3][j - 6]))) {
					return grid[i][j];
				}
			}
		}

		// Return statement if no win condition is found.
		return "no win";
	}

	// Main method.
	public static void main(String[] args) {

		// Flag.
		boolean loop = true;
		String[][] grid = createGrid();
		int playerTurn = 0;
		
		System.out.println("Welcome to Connect Four!\n");
		printGrid(grid);
		
		while (loop) {
			if (playerTurn % 2 == 0) {
				redTurn(grid);
			}
			else {
				yellowTurn(grid);
			}
			
			playerTurn++;
			
			// Reprint returned grid on console.
			printGrid(grid);
			
			// Check for win condition after each turn.
			if (checkWin(grid) != "no win") {
				if (checkWin(grid) == "R") {
					System.out.println("The red player has won.");
				}
				else if (checkWin(grid) == "Y") {
					System.out.println("The yellow player has won.");
				}

				// End the game when winner is determined.
				loop = false;
			}
		}

	}
}
