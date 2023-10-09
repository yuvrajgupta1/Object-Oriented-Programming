public class TestShapes {
	
	public static void main( String [] args ) {
		
		Point p1 = new Point( 2.0, 3.4 );		
		Point p2 = new Point( 2.0, 3.4 );
		System.out.println("p1 - " + p1 );
		System.out.println("p2 - " + p2 );
		System.out.println("p1.equals( p2 ) is "+ p1.equals( p2 ) );
		p2 = new Point( 2.5, 3.4 );
		
		
		Shape c1 = new Circle( p1.getX(), p1.getY(), 45.356 );
		System.out.println( c1 );
		Shape r1 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		System.out.println( r1 );
		
		System.out.println("p1 - " + p1 );
		System.out.println("p2 - " + p2 );
		System.out.println("p1.equals( p2 ) is "+ p1.equals( p2 ) );
		System.out.println("c1.equals( r1 ) is "+ c1.equals( r1 ) );
		System.out.println("c1.equals( c1 ) is "+ c1.equals( c1 ) );
		
		System.out.println("\n");
		p1 = new Point(2.0, 3.4);
		Shape r2 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		System.out.println("r1 - " + r1);
		System.out.println("r2 - " + r2);
		System.out.println("r1.isLeftOf( r2 ) is "+ r1.isLeftOf( r2 ) );
		System.out.println("r1.isRightOf( r2 ) is "+ r1.isRightOf( r2 ) );
		System.out.println("r1.isAtSamePointAs( r2 ) is "+ r1.isAtSamePointAs( r2 ) );
		
		p1 = new Point(2.5, 5.0);
		r2 = new Rectangle( p1.getX(), p1.getY(), 45.35, 28.56 );
		System.out.println("r1 - " + r1);
		System.out.println("r2 - " + r2);
		System.out.println("r1.isLeftOf( r2 ) is "+ r1.isLeftOf( r2 ) );
		System.out.println("r1.isRightOf( r2 ) is "+ r1.isRightOf( r2 ) );
		System.out.println("r1.isBelow( r2 ) is "+ r1.isBelow( r2 ) );
		System.out.println("r2.isAbove( r1 ) is "+ r2.isAbove( r1 ) );
		
		System.out.println("\n");
		boolean[] test = GradeLab.test();
		GradeLab.gradeLab( test );
	}
}