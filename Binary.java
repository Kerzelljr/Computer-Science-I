/**
 * Filename: Binary.java
 * Author: Kerzell Ramos
 * Date: Nov. 10th, 2017
 * Purpose: To create a program that will convert a user inputed positive 
 * 			integer into it's binary equivalent. 
 */

import java.util.*;

public class Binary {
	public static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Lab 8 written by Kerzell Ramos. \n");
		
		String prompt = "Enter a non-zero, positive integer:";
		printBinaryArray(convertToBinary(getInt(INPUT, prompt)));
	}
	
	public static int getInt(Scanner INPUT, String prompt) {
		System.out.println(prompt);
		while(!INPUT.hasNextInt()) {
			INPUT.next(); // To discard the input prompt assuming user has entered a value within 
						  // the designated parameters.
			
			System.out.println("Not an intger (whole, real number)... try again.");
			System.out.println(prompt);
		}
		
		return INPUT.nextInt();
	}
	
	public static int[] convertToBinary(int decimal) {
		int decimalCopy = decimal; //copies value of decimal as given by user
		int length = 0; //initialize length of array
		
		while(decimal > 0) {
			decimal = decimal / 2;
			length++;
		}
		
		decimal = decimalCopy;
		
		int[] binaryArray = new int[length]; //creates an array with the length of decimalLength
		int index = 0;
		
		while(decimal > 0) {
			binaryArray[index++] = decimal % 2;
			decimal = decimal / 2;
		}
		return binaryArray;
	}
	
	public static void printBinaryArray(int[] binary) {
		for(int i = binary.length - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}
}
