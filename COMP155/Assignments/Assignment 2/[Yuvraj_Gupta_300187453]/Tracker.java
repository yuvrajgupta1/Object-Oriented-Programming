/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

import tracker.test.QualityAssurance;
import tracker.test.GradeLab;
import tracker.objects.Location;
import tracker.shapes.Circle;
import tracker.shapes.Rectangle;
import tracker.objects.Address;
import tracker.objects.Person;
import java.util.*;

class Tracker {
	
	public static void main( String [] args ) {
		
		boolean[] test = QualityAssurance.test();
		GradeLab.grade( test );
		
		//Using the Location object
		Location loc1 = new Location();
		loc1 = new Location( 2.345678, 3.98756 );
		System.out.println();
		System.out.println("Testing the location object... "+ loc1 );
		
		//Using the Circle object
		Circle c1 = new Circle();
		c1.setRadius( 25.67 );
		c1.setCentrePoint( loc1 );
		System.out.println("Testing the circle object... "+ c1 );
		
		//Using the rectangle object
		Rectangle r1 = new Rectangle();
		r1.setLength( 2.0 );
		r1.setWidth( 2.0 );
		System.out.println("Testing the rectangle object... "+ r1 );
		
		//Using the address object
		Address addr1 = new Address();
		addr1.setUnit(45);
		addr1.setStreetNumber(27567);
		addr1.setStreetName("James Avenue");
		addr1.setCity("Abbotsford");
		addr1.setPostalCode("V2T 0H9");
		addr1.setProvince("British Columbia");
		Address.Type type = Address.Type.BUSINESS;
		addr1.setType( type );
		System.out.println("Testing the address object... "+ addr1 );
		
		//Using the person object
		Address addr2 = new Address();
		addr2.setUnit(45);
		addr2.setStreetNumber(27567);
		addr2.setStreetName("James Avenue");
		addr2.setCity("Abbotsford");
		addr2.setPostalCode("V2T 0H9");
		addr2.setProvince("Quebec");
		addr2.setType(Address.Type.HOME);
		
		Person p1 = new Person();
		List<Address> addresses = new ArrayList<Address>();
		addresses.add( addr1 );
		addresses.add( addr2 );
		p1.setAddresses( addresses );
		p1.setName("Opeyemi Adesina");
		p1.setStatus( Person.Status.NEGATIVE );
		p1.setAge(21);
		p1.setSex( Person.Sex.MALE );
		System.out.println("Testing the person object... "+ p1 );
		
	}
}