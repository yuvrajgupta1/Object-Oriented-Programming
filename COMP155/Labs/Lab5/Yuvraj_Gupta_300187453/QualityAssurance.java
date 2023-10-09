/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

public class QualityAssurance {
	
	
	//testing Point object
	public static boolean[] Q1() {

		boolean [] answer = new boolean[5];
		Point p1 = new Point( 2.0, 3.4 );		
		Point p2 = new Point( 2.0, 3.4 );
		answer[0] = p1.equals( p2 );
		p1.setX( 2.345678 );
		p1.setY( 3.98756 );
		answer[1] = !p1.equals( p2 );
		answer[2] = p1.getX() == 2.345678;
		answer[3] = p1.getY() == 3.98756;
		answer[4] = p1.toString().equals("Point [x: 2.345678, y: 3.98756]");
		
		return answer;
	}
	
	//testing the circle object
	public static boolean[] Q2() {

		boolean [] answer = new boolean[5];
		Point p1 = new Point( 2.0, 3.4 );
		Circle c1 = new Circle( p1.getX(), p1.getY(), 45.356 );
		answer[0] = c1.getLocation().getX() == 2.0;
		answer[1] = c1.getLocation().getY() == 3.4;
		answer[2] = c1.getRadius() == 45.356;
		Shape c2 = new Circle( p1.getX(), p1.getY(), 55.356 );
		answer[3] = ! c1.equals( c2 );
		answer[4] = c1.toString().equals("Circle [x: 2.0, y: 3.4; radius: 45.356]");
		
		return answer;
	}
	
	//testing the rectangle object
	public static boolean[] Q3() {

		boolean [] answer = new boolean[6];
		Point p1 = new Point( 2.0, 3.4 );
		Rectangle r1 = new Rectangle( p1.getX(), p1.getY(), 45.356, 28.56 );
		answer[0] = r1.getLocation().getX() == 2.0;
		answer[1] = r1.getLocation().getY() == 3.4;
		answer[2] = r1.getLength() == 45.356;
		answer[3] = r1.getWidth() == 28.56;
		Shape r2 = new Rectangle( p1.getX(), p1.getY(), 55.356, 26.57 );
		answer[4] = ! r1.equals( r2 );
		answer[5] = r1.toString().equals("Rectangle [x: 2.0, y: 3.4; length: 45.356, width: 28.56]");
		
		return answer;
	}
	
	//testing the shape object
	public static boolean[] Q4() {

		boolean [] answer = new boolean[7];
		Point p1 = new Point( 2.0, 3.4 );
		Shape r1 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		Shape r2 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		
		answer[0] = ! r1.isLeftOf( r2 );
		answer[1] = ! r1.isRightOf( r2 );
		answer[2] = r1.isAtSamePointAs( r2 );
		
		p1 = new Point(2.5, 5.0);
		r2 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		answer[3] = r1.isLeftOf( r2 );
		answer[4] = !r1.isRightOf( r2 );
		answer[5] = r1.isBelow( r2 );
		answer[6] = r2.isAbove( r1 );
		
		
		return answer;
	}
}