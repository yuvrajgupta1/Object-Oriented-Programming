public class Point {
	
	private double x, y;
	
	// parametrized constructor
	public Point( double x, double y ) {
		
		this.x = x;
		this.y = y;
	}
	
	// set x method
	public void setX( double x ) {
		
		this.x = x;
	} 
	
	// set y method
	public void setY( double y ) {
		
		this.y = y;
	} 
	
	// get x method
	public double getX() {
		
		return x;
	}
	
	// get y method
	public double getY() {
		
		return y;
	}
	
	// checks if 2 points are equal
	public boolean equals( Point other ) {
		
		return this.x == other.x && this.y == other.y;
	}
	
	// returns the information of point
	public String toString() {
		
		return "Point [x: " + getX() + ", y: " + getY() + "]";
	}
}