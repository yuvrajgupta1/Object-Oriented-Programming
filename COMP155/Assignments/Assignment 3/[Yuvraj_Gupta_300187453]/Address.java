/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

public class Address {
	
	private int unit, streetNumber;
	private String streetName, postalCode, city, province;
	public enum Type { BUSINESS, OFFICE, HOME }
	Type type;
	String country;
	
	//Constructors
	// default constructor
	public Address() {
		
		unit = 0;
		streetNumber = 0;
		streetName = "";
		postalCode = "";
		city = "";
		province = "";
		type = null;
		country = "";
	}
	
	// parametrized constructor
	public Address( int streetNumber, String streetName, String postalCode, String city, String province, Type type, String country ) {
		
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.type = type;
		unit = 0;
		this.country = country;
	}
	
	// parametrized constructor
	public Address( int unit, int streetNumber, String streetName, String postalCode, String city, String province, Type type, String country ) {
		
		this.unit = unit;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.type = type;
		this.country = country;
		
	}
	
	//Accessor methods
	public int getStreetNumber() {
		
		return streetNumber;	// returns street number of address
	}
	
	public int getUnit() {
			
		return unit;			// returns unit of address
	}
	
	public String getType() {
		
		return typeToString();	// returns the type of address in string type
	}
	
	public String getStreetName() {
	
		return streetName;		// returns street name of address
	}
	
	public String getPostalCode() {
		
		return postalCode;		// returns postal code of address
	}
	
	public String getCity() {
		
		return city;			// returns city of address
	}
	
	public String getProvince() {
	
		return province;		// returns province of address
	}
	
	public String getCountry() {
		
		return country;			// returns country of address
	}
	
	// setter methods
	public void setStreetNumber( int number ) {
		
		streetNumber = number;		// sets street number
	}
	
	public void setUnit( int unit ) {
		
		this.unit = unit;			// sets unit
	}
	
	public void setStreetName( String name ) {
		
		streetName = name;			// sets street name
	}
	
	public void setPostalCode( String code ) {
		
		postalCode = code;			// sets postal code
	}
	
	public void setCity( String city ) {
		
		this.city = city;			// sets city
	}
	
	public void setProvince( String province ) {
		
		this.province = province;	// sets province
	}
	
	public void setCountry( String country ) {
		
		this.country = country;		// sets country
	}
	
	public void setType( Type type ) {
		
		this.type = type;			// sets type of address
	}	
	
	private static String formatProvince( String provinceOrFederal ) {
			
		provinceOrFederal = provinceOrFederal.toLowerCase();
		if( provinceOrFederal.equals( "ontario" ) || provinceOrFederal.equals( "on" ) ) {
			return "ON";
		} else if( provinceOrFederal.equals( "Manitoba" ) || provinceOrFederal.equals( "mb" ) ) {
			return "MB";
		} else if( provinceOrFederal.equals( "british columbia" ) || provinceOrFederal.equals( "bc" ) ) {
			return "BC";
		} else if( provinceOrFederal.equals( "new brunswick" ) || provinceOrFederal.equals( "nb" ) ) {
			return "NB";
		} else if( provinceOrFederal.equals( "alberta" ) || provinceOrFederal.equals( "ab" ) ) {
			return "AB";
		} else if( provinceOrFederal.equals( "saskatchewan" ) || provinceOrFederal.equals( "sk" ) ) {
			return "SK";
		} else if( provinceOrFederal.equals( "nova scotia" ) || provinceOrFederal.equals( "ns" ) ) {
			return "NS";
		} else if( provinceOrFederal.equals( "quebec" ) || provinceOrFederal.equals( "qc" ) ) {
			return "QC";
		} else {
			return "federal";
		}
	}
	
	private String typeToString() {
		
		switch( type ) {
			case BUSINESS : return "BUSINESS";
			case OFFICE : return "OFFICE";
			case HOME : return "HOME";
			default : return "";
		}
	}
	
	// returns if 2 addresses are same
	public boolean equals( Address address ) {
		
		return this.unit == address.unit &&										// checks unit number		
					this.streetNumber == address.streetNumber &&				// checks street number
						this.streetName == address.streetName &&				// checks street name
							this.postalCode == address.postalCode &&			// checks postal code
								this.city == address.city &&					// checks city
									this.province == address.province &&		// checks province
										this.type == address.type;				// checks type of address
								
	}
	
	// returns information of address
	public String toString() {
		
		// if there is no unit then returns the whole address without unit
		if( unit !=  0) {
			return typeToString() + ": " + unit + "-" + streetNumber + ", " +
					streetName + ", " + city + ", " + formatProvince(province) + " "
						+ postalCode + ", " + country;
		}
		
		// else, returns the whole address
		return typeToString() + ": " + streetNumber + ", " +
					streetName + ", " + city + ", " + formatProvince(province) + " "
						+ postalCode + ", " + country;
	}
}