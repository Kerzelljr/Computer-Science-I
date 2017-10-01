/*
 * Filename: Tables.java
 * Author: Kerzell Ramos
 * Date: Sept. 5th, 2017
 * Purpose:
 */

import java.util.*;
import static java.lang.System.*;

public class Tables {
	
	public static final Scanner CONSOLE = new Scanner(in);
	public static void main(String args[]) {
		out.println("Project 1 written by Kerzell Ramos.\n");
		powerBase(); //call to powerBase method for first part
		powerRemainders(); //call to powerRemainders method for second part
	}
	
	public static void powerBase() {
		out.println("Enter a base number: ");
			int baseNum = CONSOLE.nextInt(); //base number as declared by the user
		out.println("Enter the maximum expontent that can be used: ");
			int maxExp = CONSOLE.nextInt(); //maximum exponent as declared by the user
		out.println("The base is " + baseNum + " and the maximum expontent is " + maxExp + "\n");
		out.println("Powers of " + baseNum + "\n");
		out.print("x\t" + baseNum + "^x\n");
		
		//for loop used to raise i (0 up to the baseNum) to the set Maximum Exponent
		for(int i = 0; i<=maxExp; i++) {
			out.println(i+"\t"+ Math.pow(baseNum, i));
		}
		out.println();
	} 
	
	public static void powerRemainders() {
		out.println("Enter the maximum value for the numerator: ");
			int maxNum = CONSOLE.nextInt(); //maximum numerator as declared by the user
		out.println("Enter the maximum value for the denominator: ");
			int maxDenom = CONSOLE.nextInt(); //maximum denominator as declared by the user
		out.println("The max numerator is " + maxNum + " and the max denominator is " + maxDenom + "\n");
		out.println("Remainders\n");
		out.println("n\tn%1\tn%2\tn%3");
		
		//loop used to take the numerator and obtain the remainders after being
		//divided by 1, 2 and 3
		for(int k = 1; k <= maxNum; k++) {
			out.println(k + "\t" + k%1 + "\t" + k%2 + "\t" + k%3);
		}
	}
}
