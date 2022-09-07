
import java.util.Scanner;
import java.util.HashMap;

public class Bank {
	
	private static HashMap<String, String> allAccounts;
	
	public Account OpenNewAccount(String username, String password) {
		
		Account newAccount = new Account(username, password);
		return newAccount;
		
	}
	
	public static boolean logIn(String username, String password) {
		
		if (!allAccounts.containsKey(username)) {
			System.out.println("Username does not exist");
			return false;
		}
		
		if(allAccounts.get(username).equals(password)) {
			System.out.println("Log-in successful");
			return true;
		}
		
		System.out.println("Incorrect password");
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
			case 1:
				System.out.println("Enter username");
				String inputtedUsername = sc.nextLine();
				String inputtedPassword = sc.nextLine();
				if (logIn(inputtedUsername, inputtedPassword)) {
					break;
				}
				break;
			
			case 2:
				System.out.println("Enter new username");
				break;
				
			default:
				System.out.println("invalid input");
				break;
		}
		
	}

}
