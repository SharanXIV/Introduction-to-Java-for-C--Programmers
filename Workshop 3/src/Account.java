import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Class Account
public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private java.util.Date dateCreated;

	// Default no-argument constructor.
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new java.util.Date();
	}

	// Constructor that will set id and balance from arguments.
	public Account(int newId, double newBalance) {
		this.id = newId;
		this.balance = newBalance;
		this.annualInterestRate = 0;
		this.dateCreated = new java.util.Date();
	}

	// Standard manipulators for private variables.
	public int getId() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public void setAnnualInterestRate(double newRate) {
		this.annualInterestRate = newRate;
	}

	public String getDate() {
		return this.dateCreated.toString();
	}

	public double getMonthlyInterestRate() {
		return (this.annualInterestRate / 12);
	}

	public double getMonthlyInterest() {
		return (getMonthlyInterestRate() / 100) * this.balance;
	}

	// Will add amount to the loan balance.
	public void withdraw(double withdrawAmt) {
		this.balance += withdrawAmt;
	}

	// Will subtract amount to the loan balance.
	public void deposit(double depositAmt) {
		this.balance -= depositAmt;
	}

	// Will return a new account created based on user input.
	public static Account addAccount() {

		boolean validInput = false;
		do {
			System.out.println("Please enter a valid account ID (only numbers): ");
			Scanner accountId = new Scanner(System.in);

			if (!accountId.hasNextInt()) {
				System.out.println("Error! Your entry: '" + accountId.nextLine() + "' is not valid.");
			} else {
				System.out.println("Please enter a valid balance (greater than 0): ");
				Scanner bal = new Scanner(System.in);

				if (!bal.hasNextDouble()) {
					System.out.println("Error! Your entry: '" + bal.nextLine() + "' is not valid.");
				} else {
					System.out.println("Please enter a valid interest rate: ");
					Scanner interestRate = new Scanner(System.in);

					if (!interestRate.hasNextDouble()) {
						System.out.println("Error! Your entry: '" + interestRate.nextLine() + "' is not valid.");
					} else {
						double rate = interestRate.nextDouble();
						if (checkInterestRate(rate)) {
							validInput = true;
							Account account = new Account(accountId.nextInt(), bal.nextDouble());
							account.setAnnualInterestRate(rate);
							displayAccountInfo(account);
							return account;
						} else {
							System.out.println("Error! Not a valid interest rate.");
							System.out.println("");
						}

					}
				}
			}

		} while (validInput == false);
		return null;
	}

	// Will display all account information.
	public static void displayAccountInfo(Account account) {
		System.out
		.println("******************************************************************************************");
		System.out.println("Your account ID:                   " + account.getId());
		System.out.println("Your loan balance:                 $" + account.getBalance());
		System.out.println("Your monthly interest:             $" + account.getMonthlyInterest());
		System.out.println("Your account created on:           " + account.getDate());

		int loanDuration = 0;
		if (account.getAnnualInterestRate() == 4.95) {
			loanDuration = 60;
		} else if (account.getAnnualInterestRate() == 3.95) {
			loanDuration = 48;
		} else if (account.getAnnualInterestRate() == 2.95) {
			loanDuration = 24;
		} else if (account.getAnnualInterestRate() == 1.95) {
			loanDuration = 12;
		} else if (account.getAnnualInterestRate() == .99) {
			loanDuration = 6;
		}

		System.out.println("Your loan duration is :            " + loanDuration + " months");
		System.out.println("Your interest for loan duration :  $" + (account.getMonthlyInterest() * loanDuration));
		System.out.println("Your monthly payments are :        $"
				+ (account.getBalance() + (account.getMonthlyInterest() * loanDuration)) / loanDuration);
		System.out
				.println("******************************************************************************************");
		System.out.println("");

	}

	// Ensures that the interest entered is valid.
	public static boolean checkInterestRate(double rate) {
		return (rate == 4.95 || rate == 3.95 || rate == 2.95 || rate == 1.95 || rate == 0.99);
	}

	// Main menu for application.
	public void mainMenu() {

		List<Account> bankAccounts = new ArrayList<Account>();
		boolean menuLoop = false;

		while (!menuLoop) {
			System.out.println("Welcome to the bank!");
			System.out.println("Please choose an option: ");
			System.out.println("1 - Add bank account");
			System.out.println("2 - View bank account");
			System.out.println("3 - Exit program");
			Scanner input = new Scanner(System.in);

			if (input.hasNextInt()) {
				int option = input.nextInt();

				if (option == 1) {
					bankAccounts.add(addAccount());
				} else if (option == 2) {
					System.out.println("Please enter your account number: ");
					Scanner inputId = new Scanner(System.in);

					int match = 0;

					if (inputId.hasNextInt()) {
						match = inputId.nextInt();
					} else {
						System.out.println("This is not a valid account number!");
						System.out.println("");
					}

					// Loop through arrayList to find matching ID
					boolean found = false;
					for (Account x : bankAccounts) {
						if (x.getId() == match) {
							displayAccountInfo(x);
							actionAccount(x);
							found = true;
						}
					}
					
					if (!found) {
						System.out.println("Account doesn't exist!");
						System.out.println("");
					}
				} else if (option == 3) {
					menuLoop = true;
				} else {
					System.out.println("This is not a valid menu option!");
					System.out.println("");
				}
			} else {
				System.out.println("This is not a valid menu option!");
				System.out.println("");
			}
		}

	}

	// Will allow user to action the account (withdraw, deposit or view)
	public static void actionAccount(Account x) {
		boolean menuLoop = false;

		while (!menuLoop) {
			Scanner inputAction = new Scanner(System.in);
			System.out.println("Please choose an option: ");
			System.out.println("1 - Withdraw from loan");
			System.out.println("2 - Pay towards loan");
			System.out.println("3 - View account balance");
			System.out.println("4 - Done");

			if (inputAction.hasNextInt()) {
				int action = inputAction.nextInt();

				if (action == 1) {
					System.out.println("Please enter amount to withdraw: ");
					if (inputAction.hasNextInt()) {
						int withdrawAmt = inputAction.nextInt();
						x.withdraw(withdrawAmt);
					} else {
						System.out.println("This is not a valid amount!");
						System.out.println("");
					}
				} else if (action == 2) {
					System.out.println("Please enter amount to deposit: ");
					if (inputAction.hasNextInt()) {
						int depositAmt = inputAction.nextInt();
						x.deposit(depositAmt);
					} else {
						System.out.println("This is not a valid amount!");
						System.out.println("");
					}
				}else if (action == 3) {
					displayAccountInfo(x);
				}else if (action == 4) {
					System.out.println("Going back to main menu. ");
					System.out.println("*************************");
					System.out.println("");
					menuLoop = true;
				} else {
					System.out.println("This is not a valid menu option!");
					System.out.println("");
				}
			} else {
				System.out.println("This is not a valid option!");
				System.out.println("");
			}
		}
	}
}
