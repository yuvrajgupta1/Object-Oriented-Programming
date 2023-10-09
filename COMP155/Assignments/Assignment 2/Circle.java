/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;

public class Circle extends Shape {
	
	private double radius;
	private static final double PI = 3.142; 
	
	// default constructor
	public Circle() {
	
		super();	// calls the super class default constructor
		radius = 0;
	} 
	
	// parametrized constructor
	public Circle( double radius, Location centrePoint ) {
		
		super(centrePoint);		// calls the super class parametrized constructor
		this.radius = radius;
	}
	
	// setter method
	public void setRadius( double radius ) {
		
		this.radius = radius;	// sets radius of circle
	}

	// accessor method
	public double getRadius() {
		
		return radius;			// returns the radius of circle
	}
	
	// calculate area
	public double area() {
		
		double area = PI * radius * radius;			// area formula
		area = Math.round( area * 100.0) / 100.0;	// rounding off area to 2 d.p. 
		return area;								// returns area of circle
	}
	
	// calculate perimeter
	public double perimeter() {
		
		double perimeter = 2 * PI * radius;			// perimeter formula
		perimeter = Math.round( perimeter * 100.0) / 100.0;	// rounding off perimeter to 2 d.p.
		return perimeter;							// returns perimeter of circle
	}
	
	// returns the rectangle with length = width = 2 * radius
	public Rectangle boundingRectangle() {
		
		Rectangle r1 = new Rectangle( 2 * radius, 2 * radius, getCentrePoint());	// creates a new rectangle r1 
		return r1;
	}
	
	// returns if the 2 circles are equal
	public boolean equals( Circle other ) {
		
		return this.radius == other.radius && getCentrePoint().equals(other.getCentrePoint());
	}
	
	// returns information of circle
	public String toString() {
		
		return "Circle: [radius: " + radius + ", " + getCentrePoint().toString() + "]";
	}
}