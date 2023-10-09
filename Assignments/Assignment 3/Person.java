/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

import java.util.*;
import tracker.shapes.*;

public class Person {
	
	private int identity;
	private String name;
	private double age;
	private Sex sex;
	private List<Address> addresses = new ArrayList<Address>();
	private Status status;
	private Location location = new Location();
	
	//constructors
	public Person() {
		name = null;
		age = 0.0;
		sex = Sex.UNKNOWN;
		status = Status.UNKNOWN;
		identity = 0;
	}
	
	public Person( int identity, String name, double age, Sex sex, Status status, List<Address> addresses, Location location ) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.addresses = addresses;
		this.status = status;
		this.identity = identity;
		this.location = location;
	}
	
	
	//Implementations of accessor methods
	public String getName() {
		return name;
	}
	
	public double getAge() {
		return age;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public int getIdentity() {
		return identity;
	}
	
	public Location getLocation() {
		
		return location;
	}
	
	//Implementations of setter methods
	public void setName( String name ) {
		this.name = name;	// sets name of the person
	}
	
	public void setAge( double age ) {
		this.age = age;		// sets the age of person
	}
	
	public void setSex( Sex sex ) {
		this.sex = sex;		// sets the sex of the person
	}
	
	public void setStatus( Status status ) {
		this.status = status;	// sets the COVID-19 status of the person
	}
	
	public void setAddresses( List<Address> addresses ) {
		this.addresses = addresses;	// sets the addresses of the person
	}
	
	public void setIdentity( int identity ) {
		this.identity = identity;	// sets the identity of the person
	}
	
	public void setLocation( Location location ) {
		this.location = location;	// sets the location of persons
	} 
	
	public enum Status { 
		POSITIVE, NEGATIVE, SYMPTOMATIC, ASYMPTOMATIC, UNKNOWN 
	}
	
	public enum Sex { 
		MALE, FEMALE, UNKNOWN 
	}
	
	private String sexToString() {
		
		switch( sex ) {
			case MALE : return "MALE";
			case FEMALE : return "FEMALE";
			default : return "UNKNOWN";
		}
	}
	
	private String statusToString() {
		
		switch( status ) {
			case POSITIVE : return "POSITIVE";
			case NEGATIVE : return "NEGATIVE";
			case SYMPTOMATIC : return "SYMPTOMATIC";
			case ASYMPTOMATIC : return "ASYMPTOMATIC";
			default : return "UNKNOWN";
		}
	}
	
	// checks if 2 persons are equal
	public boolean equals( Person person ) {

		return  this.identity == person.identity &&							// checks identity
					this.name == person.name &&								// checks name
						this.age == person.age &&							// checks age
							this.sex == person.sex &&						// checks sex
								this.addresses.equals(person.addresses) && 	// function call from Address class
									this.status == person.status && 		// checks status
										this.location.equals( person.location );	// function call from location class
	}

	/**Takes an operational radius and all the people in the community as arguments
	***Checks if this person (say p) is COVID-19 positive or asymptomatic and computes the list of everyone 
	in the neighbourhood that should be notified (or given an order).

	Person at location (x,y) is in the neighbourhood (i.e., in an operational radius - rad) 
	of person at location (xn, yn) if the following holds, if:
		- 'rec' be the bounding rectangle of circle with centrepoint (x,y)
		- 'rad' is the operational radius
		- 'topLeft' and 'bottomRight' be the top-left and 'bottomRight' corner points of rec 
		- x1, x2 are the longitudes of bottomLeft and topRight corners respectively
		- y1, y2 are the latitudes of bottomLeft and topRight corners respectively

		Subject to:
			y1 <= y <= y2 and x1 <= x <= x2										(1)
			p is POSITIVE or p is ASYMPTOMATIC									(2)


	ARGUMENTS:
		operational radius
		map of people in the community
	RETURN: 
		A map of neighbors within an operating radius - mapping person 
		identity with the person (i.e., Map<Integer, Person>).
	**/
	public Map<Integer, Person> getNeighbours( double radius, Map<Integer, Person> allPersons ) {

		Map<Integer, Person> neighbours = new HashMap<>();								// create new map
		
				Circle c1 = new Circle ( radius, location );							// create object circle with radius and location
				Rectangle rec = c1.getBoundingRectangle();								// create object rectangle
				double x1 = rec.getCornerPoints( radius ).get("BL").getLongitude();		// variable declaration and initilization to longitude of bottom left corner
				double x2 = rec.getCornerPoints( radius ).get("TR").getLongitude();		// variable declaration and initilization to longitude of top right corner
				double y1 = rec.getCornerPoints( radius ).get("BL").getLatitude();		// variable declaration and initilization to latitude of bottom left corner
				double y2 = rec.getCornerPoints( radius ).get("TR").getLatitude();		// variable declaration and initilization to latitude of top right corner
		
			if ( this.status == status.POSITIVE || this.status == status.ASYMPTOMATIC ) {	// checks if the person is positive or asymptomatic
				for( Map.Entry<Integer, Person> entry : allPersons.entrySet() ) {			// loop to iterate over the map of allPersons
					double x = entry.getValue().getLocation().getLongitude();				// gets the longitude of person from map
					double y = entry.getValue().getLocation().getLatitude();				// gets the longitude of person from map

					if ( x1 <= x && x <= x2 && y1 <= y && y <= y2 ) {						// checks if the person is in the range of the asymptomatic or positive person
						
						if (entry.getValue().equals(this)){									// if the person is same that is being compared
							continue;														// then move on to the next person
						}
					
						neighbours.put( entry.getKey(), entry.getValue() );					// else, put the value in the neighbours map
					}
				}
			}
		
		return neighbours;
	}
	
	// returns the information of person
	public String toString() {
		
		return "\n" + "ID: " + identity + "\n" 
					+ "Full Name: " + name + "\n" + "Age: " + age + " years\n" + "Sex: " + sexToString()
							+ "\n" + "Covid-19 Status: " + statusToString() + "\n"
									+ location.toString() + "\n" + "Contact Address(es):" + "\n " 
											+ addresses.get(0) + "\n";
	}
}