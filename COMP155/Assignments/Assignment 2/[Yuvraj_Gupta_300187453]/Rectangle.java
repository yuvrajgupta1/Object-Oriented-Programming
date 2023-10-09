/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;
import java.lang.Math;

public class Rectangle extends Shape {
	
	//instance variable
	private double length, width;
	
	// default constructor
	public Rectangle() {
		
		super();	// calls the super class default constructor
		length = 0.0;
		width = 0.0;
	} 
	
	// parametrized constructor
	public Rectangle( double length, double width, Location centrePoint ) {
		
		super( centrePoint );	// calls the super class parametrized constructor
		this.length = length;
		this.width = width;
	}
	
	
	// setter methods
	public void setLength( double length ) {
		
		this.length = length;	// sets length of rectangle
	}
	
	public void setWidth( double width ) {
		
		this.width = width;		// sets the width of rectangle
	}
	
	// accessor methods
	public double getLength() {
		
		return length;		// returns length of rectangle
	}
	
	public double getWidth() {
		
		return width;		// returns width of rectangle
	}
	
	// calculates area
	public double area() {
		
		double area = length * width;					// area formula of rectangle
		area = Math.round( area * 100.0) / 100.0;		// rounding off to 2 d.p.
		return area;									// returns area of rectangle
	}
	
	// calculates perimeter
	public double perimeter() {
		
		double perimeter = 2 * (length + width);		// perimeter formula of rectangle
		perimeter = Math.round( perimeter * 100.0) / 100.0;		// rounding off to 2 d.p.
		return perimeter;								// returns perimeter of rectangle
	}
	
	// returns the same rectangle
	public Rectangle boundingRectangle() {
		
		return this;
	}
	
	// checks if 2 rectangles are equal
	public boolean equals( Rectangle other ) {
		
		return this.length == other.length && this.width == other.width;
	}
	
	// returns the information of rectangle
	public String toString() {
		
		return "Rectangle: [length: " + length + ", width: " + width + ", " + getCentrePoint().toString() + "]";
	}
}