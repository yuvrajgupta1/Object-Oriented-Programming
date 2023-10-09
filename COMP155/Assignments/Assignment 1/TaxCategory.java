/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package canadian.payroll;

public class TaxCategory {
	
	
	//Attributes declarations
	private double lowerBound, upperBound;
	private double percentage;
	
	//defines a default constructor
	public TaxCategory() {
		
		lowerBound = upperBound = 0;
		percentage = 0;
	}
	
	public TaxCategory( double percentage, double lowerBound, double upperBound ) throws Exception {
		
		if( !isValid(lowerBound, upperBound)) {
			System.out.println("Error: upper bound must exceed or equal to the lower bound ["+lowerBound+" .. "+upperBound+"]");
			throw new Exception();
		}
		
		this.percentage = percentage;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	private boolean isValid( double lowerBound, double upperBound ) {
		
		return upperBound >= lowerBound;
	}
	
	public String toString() {
		String str = percentage + "% [$" + lowerBound +" .. $"+ upperBound+"]";
		return str;
	}
	
	public double getUpperBound() {
		
		return upperBound;
	}
	
	public void setUpperBound( double upperBound ) {
		
		this.upperBound = upperBound;
	}
	
	public double getLowerBound() {
		
		return lowerBound;
	}
	
	public void setLowerBound( double lowerBound ) {
		
		this.lowerBound = lowerBound;
	}
	
	public double getPercentage() {
		
		return percentage;
	}
	
	public void setPercentage( float percentage ) {
		
		this.percentage = percentage;
	}
}