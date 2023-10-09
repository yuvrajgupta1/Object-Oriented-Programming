public class Rectangle extends Shape {
	
	private double length, width;
	
	// parametrized constructor
	public Rectangle( double x, double y, double length, double width ) {
		
		super( x, y );
		this.length = length;
		this.width = width;
	}
	
	// get length method
	public double getLength() {
		
		return length;
	}
	
	// get width method
	public double getWidth() {
		
		return width;
	}
	
	// set length method
	public void setLength( double length ) {
		
		this.length = length;
	}
	
	// set width method
	public void setWidth( double width ) {
		
		this.width = width;
	}
	
	// checks if 2 rectangles are equal
	public boolean equals( Shape other ) {
		
		// if other does not have any shape then return false
		if ( other == null ) {
			
			return false;
		}
		
		// if the class of both the objects is not same then return false
		else if ( this.getClass() != other.getClass() ) {
			
			return false;
			
		} else {	
			
			Rectangle obj = (Rectangle) other;	//type casting
			return isAtSamePointAs( other ) && this.length == obj.length && this.width == obj.width;	//checks if both have same dimensions
		}
	}
	
	// returns the information of rectangle
	public String toString() {
		
		return "Rectangle [x: " + getLocation().getX() + ", y: " + getLocation().getY() + "; length: " + getLength() + ", width: " + getWidth() + "]";
	}
}