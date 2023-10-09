/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;
import java.util.*;

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
	
	/**This method converts the rectangle to its corner points using the following mathematical, let
			radius be the operational radius of coverage
			(x,y) be the centrepoint of the rectangle
				then
					x1 = radius + x
					x2 = x - radius
					y1 = radius + y
					y2 = y - radius 
			
				AND
					(x1, y1) defines top-right corner with key - TR
					(x1, y2 ) defines bottom-right corner with key - BR
					(x2, y1) defines top-left corner with key - TL
					(x2, y2) defines bottom-left corner with key - BL
		ARGUMENTS:
			radius - operational radius of coverage

		RETURN:
			corners - a map of the corner points of a rectangle shape

	**/
	public Map <String, Location> getCornerPoints( double radius ) {
		
		Map<String, Location> corners = new HashMap<>();			// creating a new map
		try{														// using try and catch to avoid null pointer exception error
		double x1 = radius + getCentrePoint().getLongitude();		// calculates the respective values as mentioned above
		double x2 = getCentrePoint().getLongitude() - radius;
		double y1 = radius + getCentrePoint().getLatitude();
		double y2 = getCentrePoint().getLatitude() - radius;
		
		
		corners.put( "TR", new Location ( x1, y1 ) );				// putting elements into the map as mentioned above
		corners.put( "BR", new Location ( x1, y2 ) );
		corners.put( "TL", new Location ( x2, y1 ) );
		corners.put( "BL", new Location ( x2, y2 ) );
		} catch(Exception e){};
		return corners;												// returns a list of corner points of a rectangle
	}
	
	// returns the same rectangle
	public Rectangle getBoundingRectangle() {
		
		return this;
	}
	
	// checks if 2 rectangles are equal
	public boolean equals( Rectangle other ) {
		if( other != null ) {
			return length == other.length && width == other.width && getCentrePoint().equals( other.getCentrePoint() );
		}
		return false;
	}
	
	// returns the information of rectangle
	public String toString() {
		
		return "Rectangle: [length: " + length + ", width: " + width + ", " + getCentrePoint().toString() + "]";
	}
}