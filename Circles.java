package Lab5;

import java.util.*;
import java.awt.*;

public class Circles {
	
	final static Scanner INPUT = new Scanner(System.in);
	
	//declaring integers
	static int rad1, rad2, rad3, x1, x2, x3, y1, y2, y3, diam1, diam2, diam3;
	
	public static void main(String args[]) {
		
		DrawingPanel panel = new DrawingPanel(400, 300); //graphics panel at 400x300 size
		Graphics g = panel.getGraphics();
		
		System.out.println("Lab 5 written by Kerzell Ramos \n");
		
		//circle one
		System.out.println("Enter the radius for circle one:");
		rad1 = INPUT.nextInt();
		System.out.println("Enter the coordinates for the center of the first cirlce (x coord first)");
		x1 = INPUT.nextInt();
		y1 = INPUT.nextInt();
		//diam1 = 2 * rad1;
		g.setColor(Color.red); 
		g.fillOval(x1-rad1, y1-rad1, rad1*2, rad1*2);
		
		//circle two
		System.out.println("Enter the radius for cirlce two:");
		rad2 = INPUT.nextInt();
		System.out.println("Enter the coordinates for the center the second circle:");
		x2 = INPUT.nextInt();
		y2 = INPUT.nextInt();
		//diam2 = 2 * rad2;
		g.setColor(Color.cyan);
		g.fillOval(x2-rad2, y2-rad2, rad2*2, rad2*2);
		
		//circle three
		System.out.println("Enter the radius for circle three:");
		rad3 = INPUT.nextInt();
		System.out.println("Enter the coordinates for the center of the third cirlce:");
		x3 = INPUT.nextInt();
		y3 = INPUT.nextInt();
		//diam3 = 2 * rad3;
		g.setColor(Color.green);
		g.fillOval(x3-rad3, y3-rad3, rad3*2, rad3*2);
		
		//compare circles based on size to see which is bigger.
		int n = compareSizes(rad1, rad2);
		if(n == 1) {
			System.out.println("The red circle is larger than the cyan.");
		}else if(n == -1) {
			System.out.println("The cyan cirlce is larger than the red.");
		}else {
			System.out.println("The red and cyan circles are the same size.");
		}
		
		int m = compareSizes(rad2, rad3);
		if(m == 1) {
			System.out.println("The cyan circle is larger than the green.");
		}else if(n == -1) {
			System.out.println("The green circle is larger than the cyan.");
		}else {
			System.out.println("The cyan and green circles are the same size.");
		}
		
		int o = compareSizes(rad1, rad3);
		if(o == 1) {
			System.out.println("The red circle is larger than the green.");
		}else if(o == -1) {
			System.out.println("The green circle is larger than the red.");
		}else {
			System.out.println("The red and green circles are the same size.");
		}
		
		//Check to see if circles intersect.
		boolean i = areIntersecting(x1, y1, rad1, x2, y2, rad2);
			if( i == true) {
			System.out.println("The red and cyan circles are intersecting.");
			}else {
			System.out.println("The red and cyan circles do not intersect.");
		}
		
		boolean j = areIntersecting(x2, y2, rad2, x3, y3, rad3);
			if(j == true) {
				System.out.println("The cyan and green circles are intersecting.");
			}else {
			System.out.println("The cyan and green circles are not intersecting.");
		}
			
		boolean k = areIntersecting(x1, y1, rad1, x3, y3, rad3);
			if (k == true) {
				System.out.println("The red and green circles are intersecting.");
			}else {
				System.out.println("The red and green circles are not intersecting.");
			}		
	}
	public static int compareSizes(int radius1, int radius2) {		
		if(radius1 > radius2) {
			return 1;
		}else if(radius1 < radius2) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public static boolean areIntersecting(int radius1, int radius2, int x1, int y1, int x2, int y2) {
		int dist = (int) Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
		int rad = radius1 + radius2;
		
		if(dist <= rad) {
			return true;
		}else {
			return false;
		}
	}
}
