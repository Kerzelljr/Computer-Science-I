/**
 * Filename: Coins.java
 * Author: Kerzell Ramos
 * Date: Aug. 30th, 2017
 * Purpose:
 */

import java.util.*;
import static java.lang.System.*; //used so I don't have to type System every time.

public class Coins {
	
	//Scanner object - final because it will NOT change.
	public static final Scanner INPUT = new Scanner(in);

	public static void main(String args[]) {
		out.println("Lab 2 written by Kerzell Ramos. \n");
		dollarAmount(); //call to dollarAmount method
		change(); //call to change method.
	}
	
	public static void dollarAmount() {
		//initialize variables for coins
		int p, n, d, q;
		
		out.println("Enter the number of pennies: ");
			p = INPUT.nextInt();
		out.println("Enter the number of nickels: ");
			n = INPUT.nextInt();
		out.println("Enter the number of dimes: ");
			d = INPUT.nextInt();
		out.println("Enter the number of quarters: ");
			q = INPUT.nextInt();
		
		//initialized total integer variable
		int total = p + n + d + q;
		out.println("The total number of coins you have is: " + total + "\n");	
		
		//multiples number of pennies, nickels, dimes and quarters stated by the user by their respected amounts
		//to obtain the monetary value of each respective coin.
		double amountP = p * .01; 
		double amountN = n * .05; 
		double amountD = d * .10; 
		double amountQ = q * .25; 
		double dollarTotal = amountP + amountN + amountD + amountQ; 
		
		out.println("You have " + p + " pennies which equates to " + amountP + " cents.");
		out.println("You have " + n + " nickel(s), which equates to " + amountN + " cents.");
		out.println("You have " + d + " dimes which equates to " + amountD + " cents.");
		out.println("You have " + q + " quarters which equates to " + amountQ + " cents (or dollars).");
		out.println("You have a grand total of: $" + dollarTotal+ "\n");
	}
		
	public static void change() {
		double totalAmount; //initialized variable
		out.println("Enter the total amount that you have: $");
		totalAmount = INPUT.nextDouble();		
		double numbQuarters = totalAmount / .25; //takes total dollar amount and gets the number of quarters.
		double totalAfterQuarters = totalAmount % .25; //takes total dollar amount and divides to get the remaining change after quarters.
		double numbDimes = totalAfterQuarters / .10;// takes total dollar amount and gets number of dimes.
		double totalAfterDimes = totalAfterQuarters % .10; //takes total dollar amount and divides to get remaining change after dimes.
		double numbNickles = totalAfterDimes / .05; //takes total dollar amount and gets number of nickels.
		double totalAfterNickles = totalAfterDimes % .05; //takes total dollar amount and divides to get remaining change after nickels.
		double numbPennies = totalAfterNickles / .01; //takes remaining balance and divides by .01 to get number of pennies.
		
		//prints out the number of coins the user has in quarters, dimes, nickels and pennies. 
		//Math.floor is used to round down
		//Math.ceil is used to round up
		out.println("You have " + Math.floor(numbQuarters) + " quarters.");
		out.println("You have " + Math.floor(numbDimes) + " dimes.");
		out.println("You have " + Math.floor(numbNickles) + " nickels,");
		out.println("You have " + Math.ceil(numbPennies) + " pennies.");	
	}
}
