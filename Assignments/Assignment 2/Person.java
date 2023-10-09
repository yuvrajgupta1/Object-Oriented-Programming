/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

import java.util.*;

public class Person {
	
	// variable declarations
	private int identity;
	private String name;
	private double age;
	private Sex sex = Sex.UNKNOWN;
	private List<Address> addresses = new ArrayList<Address>();
	private Status status = Status.UNKNOWN;
	
	//constructors
	//default constructor
	public Person() {
		identity = 0;
		name = "";
		age = 0.0;
		sex = Sex.UNKNOWN;
		List<Address> addresses; 
		status = Status.UNKNOWN;
	}
	
	//parametrized constructor
	public Person( int identity, String name, double age, Sex sex, Status status, List<Address> addresses ) {
		this.identity = identity;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.status = status;
		this.addresses = addresses;
	}
	
	
	//Implementations of accessor methods
	public String getName() {
		return name;		//returns name of the person
	}
	
	public double getAge() {
		return age;			//returns age of the person
	}
	
	public String getSex() {
		return sexToString(); //returns sex in String type
	}
	
	public String getStatus() {
		return statusToString();	// returns COVID-19 status in String type
	}
	
	public List<Address> getAddresses() {
		return addresses;	// returns the list of addresses
	}
	
	public int getIdentity() {
		return identity;	// returns the identity of person
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
	
	//checks if the two persons are equal
	public boolean equals( Person person ) {

		return  this.name == person.name &&
					this.age == person.age &&
						this.sex == person.sex &&
							addresses.equals(person.addresses) && 	//function call from Address class
								this.status == person.status;
	}
	
	//returns the information of the person
	public String toString() {
		
		return "\n" + "Full Name: " + name + "\n" + "Age: " + age + " years\n" + "Sex: " + sexToString()
												+ "\n" + "Covid-19 Status: " + statusToString() + "\n"
														+ "Contact Address(es):" + "\n " + addresses.get(0) + "\n "
																+ addresses.get(1);
	}
}