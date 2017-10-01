/**
 * Filename: FutureValues.java
 * Author: Kerzell Ramos
 * Lab: #3
 * Purpose: To compute the future values of two accounts based on the initial value of the account, 
 * 			the interest rate and the number of years the account has been open.  
 */ 

import java.util.*;
import java.text.*;

public class FutureValues {
	
	static double compoundIntRate, annuityIntRate, presentVal, yearlyPayments;
	static int compoundYears, annuityYears;

	public static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Lab 3 written by Kerzell Ramos \n");
		
		//COMPOUND CALCULATOR		
		System.out.println("What is the current dollar value of your account? ");
		presentVal = INPUT.nextDouble();
		
		System.out.println("What is the current interest rate associated with this account?");
		compoundIntRate = INPUT.nextDouble();
		
		System.out.println("How many years has the account been open for?");
		compoundYears = INPUT.nextInt();	
		
		System.out.println("Your account value with compound interest after " + compoundYears + " years, is $"
							+ Math.floor(getCompoundValue()) + "\n");
		
		//ANNUITY CALCULATOR		
		System.out.println("Enter your yearly payment:");
		yearlyPayments = INPUT.nextDouble();
		
		System.out.println("What is the current interest rate associated with this account?");
		annuityIntRate = INPUT.nextDouble();	
		
		System.out.println("How many years of interest on the account?");
		annuityYears = INPUT.nextInt();
		
		System.out.println("Your future account value with annuity interest after " + annuityYears + " years is "
							+ moneyString(getAnnuityValue(yearlyPayments)));
	}
	
	 public static double getCompoundValue() {
		 return presentVal * Math.pow((1 + (compoundIntRate/100)), compoundYears);
	}
	
	public static double getAnnuityValue(double yearlyPayment) {
		return yearlyPayment * (Math.pow(1 + (annuityIntRate/100), annuityYears)-1 )/(annuityIntRate/100);
	}	
	
	//Returns a string $dollars.cents rounded to the nearest cent
	public static String moneyString(double amount) {
		DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
		return dollarsAndCents.format(amount);
		
	}
}
