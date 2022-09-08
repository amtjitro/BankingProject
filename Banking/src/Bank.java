
import java.util.Scanner;
import java.util.HashMap;

public class Bank {

	private static HashMap<String, Account> allAccounts;

	public static Account OpenNewAccount(String username, String password) {

		Account newAccount = new Account(username, password);
		allAccounts.put(username, newAccount);
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
	
	public static void changePassword(String username, String password) {
		allAccounts.get(username).setPassword(password);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		allAccounts = new HashMap<String, Account>();
		
		Account a = new Account("user", "pass");
		allAccounts.put("user", a);
		
		boolean quitProgram = false;
		boolean quitOptions = false;
		boolean passedLogInScreen = true;
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
						currentAccount = allAccounts.get(inputtedUser);
						
						break;
					}
					System.out.println("Incorrect password");
					System.out.println("Forgot password? Type yes to reset or no to go back");
					
					String yesOrNo = sc.next();
					
					switch (yesOrNo) {
					case "yes":
						System.out.println("Enter new password");
						
						String newPass = sc.next();
						
						changePassword(inputtedUser, newPass);
						
						System.out.println("Password successfully reset");
						
					default:
						passedLogInScreen = false;
					}
					
				} else {
					passedLogInScreen = false;
				}

				break;

			// sign up case
			case 2:
				System.out.println("Enter new username");
				String inputtedNewUser = sc.next();
				
				if (allAccounts.containsKey(inputtedNewUser)) {
					System.out.println("Username taken.");
					passedLogInScreen = false;
				} else {
					System.out.println("Enter password");
					String inputtedNewPass = sc.next();
					currentAccount = OpenNewAccount(inputtedNewUser, inputtedNewPass);
					System.out.println("Account successfully created.");
				}
				
				break;

			// quit
			case 3:
				System.out.println("Thank you for using this banking system");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid selection. Please try again:");
				passedLogInScreen = false;
				
			}
			
			while (passedLogInScreen & !quitOptions) {
				// only get here if successful log in or sign up
				System.out.println("Enter the corresponding number to your desired option:");
				//System.out.println("1. Open Money Market account");
				System.out.println("1. Withdraw");
				System.out.println("2. Deposit");
				System.out.println("3. Check balance");
				System.out.println("4. Sign out");
				//System.out.println("4. Transfer funds between accounts");
				
				int response = sc.nextInt();
				
				switch (response) {
				case 1:
					System.out.println("How much would you like to withdraw?");
					Double withdrawalAmount = sc.nextDouble();
					currentAccount.withdraw(withdrawalAmount);
					break;
					
				case 2:
					System.out.println("How much would you like to deposit?");
					Double depositAmount = sc.nextDouble();
					currentAccount.deposit(depositAmount);
					break;
					
				case 3:
					System.out.println("Your current balance in your account is: $" + currentAccount.getBalance());
					break;
					
				case 4:
					System.out.println("Successfully signed out.");
					quitOptions = true;
					break;
					
				default:
					System.out.println("Invalid selection. Please try again:");
					break;
				}
				
				
			}
			

		}

		sc.close();
	}

}
