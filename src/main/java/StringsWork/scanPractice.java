package StringsWork;
import java.util.Scanner;  // Import the Scanner class

public class scanPractice {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);   
	    System.out.println("Enter username");

	    String userName = myObj.nextLine();  // Read user input
	    System.out.println("Username is: " + userName);  // Output user input

	}
	
	public void scanPrac() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name: ");
		
		String userName = sc.nextLine();
		System.out.println("You typed: " + userName) ;
		
		
	}
}

