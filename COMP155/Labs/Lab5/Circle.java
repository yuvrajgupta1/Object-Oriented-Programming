public class Circle extends Shape {
	
	private double radius;
	
	// parametrized constructor
	public Circle( double x, double y, double radius ) {

		super(x , y);
		this.radius = radius;
	}
	
	// get radius method
	public double getRadius() {
		
		return radius;
	}
	
	// set radius method
	public void setRadius( double radius ) {
		
		this.radius = radius;
	}
	
	// checks if 2 circles are equal
	public boolean equals( Shape other ) {
		
		// if other does not have any shape then return false
		if ( other == null ) {
			
			return false;
		}
		
		// if the class of both the objects is not same then return false
		else if ( this.getClass() != other.getClass() ) {
			
			return false;
			
		} else {	
			
			Circle obj = (Circle) other;	//type casting
			return isAtSamePointAs( other ) && this.radius == obj.radius;	//checks if both have same dimensions
		}
	}
	
	// returns the information of circle
	public String toString() {
		
		return "Circle [x: " + getLocation().getX() + ", y: " + getLocation().getY() + "; radius: " + getRadius() + "]";
	}
}