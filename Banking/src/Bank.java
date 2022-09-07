
import java.util.Scanner;
import java.util.HashMap;

public class Bank {

	private static HashMap<String, Account> allAccounts;

	public Account OpenNewAccount(String username, String password) {

		Account newAccount = new Account(username, password);
		return newAccount;

	}

	public static boolean checkUser(String username) {

		if (!allAccounts.containsKey(username)) {
			System.out.println("Username does not exist");
			return false;
		}

		return true;
	}

	public static boolean checkPassword(String username, String password) {
		if (allAccounts.get(username).getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		allAccounts = new HashMap<String, Account>();
		
		Account a = new Account("user", "pass");
		allAccounts.put("user", a);
		
		boolean quitProgram = false;
		boolean quitOptions = false;
		Account currentAccount = null;
		System.out.println("***Welcome to the banking system***");

		while (!quitProgram) {
			System.out.println("Enter the corresponding number to your desired option:");
			System.out.println("1. Log In");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit Banking Program");

			int firstResponse = sc.nextInt();

			switch (firstResponse) {

			// log in case
			case 1:
				System.out.println("Enter username");
				String inputtedUser = sc.next();
				boolean validUser = checkUser(inputtedUser);
				if (validUser) {
					System.out.println("Username found. Enter Password:");
					String inputtedPassword = sc.next();
					boolean matchingPass = checkPassword(inputtedUser, inputtedPassword);
					if (matchingPass) {
						System.out.println("Log-in successful");
						break;
					}
					System.out.println("Incorrect password");
				}

				break;

			// sign up case
			case 2:
				System.out.println("Enter new username");
				String inputtedNewUser = sc.next();

				System.out.println("Enter password");
				String inputtedNewPass = sc.next();

				Account newSignUp = new Account(inputtedNewUser, inputtedNewPass);

				break;

			// quit
			default:
				System.out.println("Thank you for using this banking system");
				sc.close();
				return;
			}
			
//			while (!quitOptions) {
//				// only get here if successful log in or sign up
//				System.out.println("Select from the following actions:");
//			}

			//quitProgram = true;

		}

		sc.close();
	}

}
