/**
 * Filename: StarWarsName.java
 * Author: Kerzell Ramos
 * Date: Oct. 2nd, 2017
 * Lab: #4
 * Purpose: To create a name generator that takes a user inputed name 
 * 			and converts it into a Star Wars style name.
 */

package Lab4;

import java.util.*;

public class StarWarsName {
	public static final Scanner INPUT = new Scanner(System.in);
	public static String firstName, lastName, motherName, city, car, firstStarWarsName, lastStarWarsName, planet;
	
	public static void main(String args[]) {
		System.out.println("Enter your first name:");
		firstName = INPUT.nextLine();
		firstName = firstName.substring(0,3).toUpperCase();
		
		System.out.println("Enter your last name:");
		lastName = INPUT.nextLine();
		String lnForPlanet = lastName.substring(lastName.length()-2).toUpperCase();
		lastName = lastName.substring(0,2).toUpperCase();
		
		System.out.println("Enter your mother's maiden name:");
		motherName = INPUT.nextLine();
		motherName = motherName.substring(0,2).toUpperCase();
		
		System.out.println("Enter the city you were born in:");
		city = INPUT.nextLine();
		city = city.substring(0,3).toUpperCase();
		
		System.out.println("Enter the first type of car you drove:");
		car = INPUT.nextLine().toUpperCase();
		
		firstStarWarsName = firstName + lastName;
		lastStarWarsName = motherName + city;
		planet = lnForPlanet + car;
		
		System.out.println(firstStarWarsName + " " + lastStarWarsName + " from the planet " + planet);
	}
}
