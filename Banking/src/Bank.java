
import java.util.Scanner;
import java.util.HashMap;

public class Bank {
	
	private static HashMap<String, String> allAccounts;
	
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
		if(allAccounts.get(username).equals(password)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		allAccounts = new HashMap<String, String>();
		allAccounts.put("user", "pass");
		
		System.out.println("***Welcome to the banking system***");
		System.out.println("Select from the following options:");
		System.out.println("1. Log In");
		System.out.println("2. Sign Up");
		
		int firstResponse = sc.nextInt();
		
		switch(firstResponse) {
		
			// log in case
			case 1:
				System.out.println("Enter username");
				String inputtedUser = sc.next();
				boolean validUser = checkUser(inputtedUser);
				if (validUser) {
					System.out.println("Valid Username. Enter Password:");
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
				break;
				
			// invalid choice
			default:
				System.out.println("invalid input");
				sc.close();
				return;
		}
		
		// only get here if successful log in or sign up
		System.out.println("Select from the following actions:");
		
		sc.close();
	}

}
