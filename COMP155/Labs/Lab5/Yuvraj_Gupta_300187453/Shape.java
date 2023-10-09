public abstract class Shape {
	
	private Point location;
	
	// parametrized constructor
	public Shape( double x, double y ) {
		
		location = new Point (x, y);
		
	}
	
	// set method
	public void setLocation( Point point ) {
		
		location = point;
	}
	
	// get method
	public Point getLocation() {
		
		return location;
	}
	
	// checks if the shape is left of other shape
	public boolean isLeftOf( Shape other ) {
		
		if( other == null ) {
			return false;
		} else {
			Point p = other.getLocation();
			
			// comparison of x values of shapes
			return location.getX() < p.getX();
		}
	}
	
	// checks if the shape is right od other shape
	public boolean isRightOf( Shape other ) {
		
		if( other == null ) {
			return false;
		} else {
			Point p = other.getLocation();
			
			// comparison of x values of shapes
			return location.getX() > p.getX();
		}
	}
	
	// checks if  the shape is above of the other shape
	public boolean isAbove( Shape other ) {
		
		if( other == null ) {
			return false;
		} else {
			Point p = other.getLocation();
			
			// comparison of y values of shapes
			return location.getY() > p.getY();
		}
	}
	
	// checks if the shape is below of other shape
	public boolean isBelow( Shape other ) {
		
		if( other == null ) {
			return false;
		} else {
			Point p = other.getLocation();
			
			// comparison of y values of shapes
			return location.getY() < p.getY();
		}
	}
	
	// checks if the shapes are on the same point
	public boolean isAtSamePointAs( Shape other ) {
		
		if( other == null ) {
			return false;
		} else {
			Point p = other.getLocation();
			
			// comparison of x and y values of shapes
			return location.getX() == p.getX() && location.getY() == p.getY();
		}
	}
}