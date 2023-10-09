/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.test;

import tracker.objects.*;
import tracker.shapes.*;
import java.util.*;

public class QualityAssurance {
	
	
	//testing Location object
	public static boolean[] Q1() {

		boolean [] answer = new boolean[5];
		//testing default constructor
		Location loc1 = new Location();
		Location loc2 = new Location();
		answer[0] = loc1.equals( loc2 );
		loc1 = new Location( 2.345678, 3.98756 );
		loc2.setLongitude( 2.345678 );
		loc2.setLatitude( 3.98756 );
		answer[1] = loc1.equals( loc2 );
		answer[2] = loc1.getLongitude() == 2.345678;
		answer[3] = loc1.getLatitude() == 3.98756;
		answer[4] = loc1.toString().equals("Located at: [longitude: 2.345678, latitude: 3.98756]");
		//System.out.println( loc1 );
		
		return answer;
	}
	
	//testing Circle object
	public static boolean[] Q2() {

		boolean [] answer = new boolean[7];
		//testing default constructor
		Location loc1 = new Location();
		loc1 = new Location( 2.345678, 3.98756 );
		Circle c1 = new Circle();
		Circle c2 = new Circle(0.0, new Location(0.0, 0.0));
		answer[0] = c1.equals(c2);
		
		c1.setRadius( 25.67 );
		c1.setCentrePoint( loc1 );
		c2.setRadius( 25.67 );
		c2.setCentrePoint( loc1 );
		answer[1] = c1.equals(c2);
		answer[2] = c1.getCentrePoint().equals( loc1 );
		answer[3] = c1.getRadius() == 25.67;
		answer[4] = c1.toString().equals("Circle: [radius: 25.67, Located at: [longitude: 2.345678, latitude: 3.98756]]");
		answer[5] = c1.area() == 2070.42;
		answer[6] = c1.perimeter() == 161.31;
		
		return answer;
	}
	
	//testing Rectangle object
	public static boolean[] Q3() {

		boolean [] answer = new boolean[6];
		//testing default constructor
		Location loc1 = new Location();
		loc1 = new Location( 2.345678, 3.98756 );
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(0.0, 0.0, new Location(0.0, 0.0));
		answer[0] = r1.equals( r2 );
		
		r1.setLength( 2.0 );
		r1.setWidth( 2.0 );
		answer[1] = r1.getLength() == 2.0;
		answer[2] = r1.getWidth() == 2.0;
		answer[3] = r1.area() == 4.0;
		answer[4] = r1.perimeter() == 8.0;
		
		//Commented to prevent a null pointer error. You must uncomment for this test case to pass
		answer[5] = r1.boundingRectangle().equals( r1 );
		
		return answer;
	}
	
	//testing the Address class
	public static boolean[] Q4() {

		boolean [] answer = new boolean[10];
		Address addr1 = new Address();
		Address addr2 = new Address();
		answer[0] = addr1.equals( addr2 );
		
		//testing its accessor methods (both setters and getters)
		addr1.setUnit(45);
		addr1.setStreetNumber(27567);
		addr1.setStreetName("James Avenue");
		addr1.setCity("Abbotsford");
		addr1.setPostalCode("V2T 0H9");
		addr1.setProvince("British Columbia");
		
		Address.Type type = Address.Type.BUSINESS;
		addr1.setType( type );
		answer[1] = addr1.getUnit() == 45;
		answer[2] = addr1.getStreetNumber() == 27567;
		answer[3] = addr1.getCity() == "Abbotsford";
		answer[4] = addr1.getPostalCode() == "V2T 0H9";
		answer[5] = addr1.getProvince() == "British Columbia";
		answer[6] = addr1.getStreetName() == "James Avenue";
		
		//testing the overloaded equals(...)
		addr2 = new Address( 45, 27567, "James Avenue", "V2T 0H9", "Abbotsford", "British Columbia", type );
		answer[7] = addr1.equals( addr2 );
		
		//testing the toString(...) method
		answer[8] = addr1.toString().equals("BUSINESS: 45-27567, James Avenue, Abbotsford, BC V2T 0H9");
		addr2 = new Address( 27567, "James Avenue", "V2T 0H9", "Abbotsford", "British Columbia", type );
		answer[9] = addr2.toString().equals("BUSINESS: 27567, James Avenue, Abbotsford, BC V2T 0H9");
		
		//testing defualt constructor
		return answer;	
	}
	
	//testing the Person class
	public static boolean[] Q5() {

		boolean [] answer = new boolean[10];
		Person p1 = new Person();
		Person p2 = new Person();
		answer[0] = p1.equals( p2 );
		
		Address addr1 = new Address();
		addr1.setUnit(45);
		addr1.setStreetNumber(27567);
		addr1.setStreetName("James Avenue");
		addr1.setCity("Montreal");
		addr1.setPostalCode("V2T 0H9");
		addr1.setProvince("Quebec");
		addr1.setType(Address.Type.BUSINESS);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add( addr1 );
		p1.setAddresses( addresses );
		p2.setAddresses( addresses );
		answer[1] = p1.equals( p2 );
		
		Address addr2 = new Address();
		addr2.setUnit(45);
		addr2.setStreetNumber(27567);
		addr2.setStreetName("James Avenue");
		addr2.setCity("Abbotsford");
		addr2.setPostalCode("V2T 0H9");
		addr2.setProvince("British Columbia");
		List<Address> addresses2 = new ArrayList<Address>();
		addresses2.add( addr2 );
		p2.setAddresses( addresses2 );
		answer[2] = !( p1.equals( p2 ) );
		
		addresses = new ArrayList<Address>();
		addresses.add( addr2 );
		addresses.add( addr1 );
		p1.setAddresses( addresses );
		p2.setAddresses( addresses );
		answer[3] = p1.equals( p2 );
		
		addresses2 = new ArrayList<Address>();
		addresses2.add( addr1 );
		addresses2.add( addr2 );
		p2.setAddresses( addresses2 );
		answer[4] = !( p1.equals( p2 ) );
		
		p1.setName("Opeyemi Adesina");
		p1.setStatus( Person.Status.NEGATIVE );
		p1.setAge(21);
		p1.setSex( Person.Sex.MALE );
		answer[5] = p1.getName().equals( "Opeyemi Adesina" );
		answer[6] = p1.getAge() == 21.0;
		answer[7] = p1.getSex() == "MALE";
		answer[8] = p1.getStatus() == "NEGATIVE";
		
		p2 = new Person(101, "Opeyemi Adesina", 21.0, Person.Sex.MALE, Person.Status.NEGATIVE, addresses );
		answer[9] = p1.equals( p2 );
		addresses2 = new ArrayList<Address>();
		addresses2.add( addr1 );
		p2.setAddresses( addresses2 );
		
		//testing defualt constructor
		return answer;
	}
	
	public static boolean evaluateQuestion( boolean [] questions ) {
		
		boolean answer = questions[0];
		for( boolean question : questions ) {
			answer = answer && question;
		}
		return answer;
	}

	public static boolean[] test() {
		
		boolean[] test = new boolean[5];
		
		test[0] = evaluateQuestion( Q1() );
		test[1] = evaluateQuestion( Q2() );
		test[2] = evaluateQuestion( Q3() );
		test[3] = evaluateQuestion( Q4() );
		test[4] = evaluateQuestion( Q5() );
		return test;
	}
}