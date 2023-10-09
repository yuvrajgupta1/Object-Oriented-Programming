/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.objects;

public class Location {
	
	double longitude, latitude;
	
	// default constructor
	public Location() {
		
		longitude = 0.0;
		latitude = 0.0;
	}
	
	// parametrized constructor
	public Location( double longitude, double latitude ) {
		
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	// getter methods
	public double getLongitude() {
		
		return longitude;		// returns the longitude of location
	}
	
	public double getLatitude() {
		
		return latitude;		// returns latitude of location
	}
	
	// setter methods
	public void setLongitude( double longitude ) {
		
		this.longitude = longitude;	// sets the longitude of location
	}
	
	public void setLatitude( double latitude ) {
		
		this.latitude = latitude;	// sets the latitude of location
	}
	
	// checks if the 2 locations are equal
	public boolean equals( Location other ) {
		
		return this.latitude == other.latitude && this.longitude == other.longitude;
	}
	
	// returns the information of Location
	public String toString() {
		
		return "Located at: [longitude: " + getLongitude() + ", latitude: " + getLatitude() + "]" ;
	}
}