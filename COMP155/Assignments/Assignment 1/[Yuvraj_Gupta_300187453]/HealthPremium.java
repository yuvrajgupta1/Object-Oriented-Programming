/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package canadian.payroll;

public class HealthPremium extends Deduction {
	
	public HealthPremium( Employee employee ) {
		super( employee );
	}
	
	public double computeAmount() {
		
		double income = employee.getIncome();
		
		//variable declaration and initialization
		double healthPrem = 0.00;
		
		//setting Health Premium brackets
		if ( income > 202000.00 ) {
			
			healthPrem = 750 + 0.25 * ( income - 202000.00 );
			
			//setting max value of healthPrem
			if ( healthPrem > 900.00 ) {
				healthPrem = 900.00;
			}
		}
		
		else if ( income > 74000.00 ) {
			
			healthPrem = 600 + 0.25 * ( income - 74000.00 );
			
			//setting max value of healthPrem
			if ( healthPrem > 750.00 ) {
				healthPrem = 750.00;
			}
		}
		
		else if ( income > 50000.00 ) {
			
			healthPrem = 450 + 0.25 * ( income - 50000.00 );
			
			//setting max value of healthPrem
			if ( healthPrem > 600.00 ) {
				healthPrem = 600.00;
			}
		}
		
		else if ( income > 38000.00 ) {
			
			healthPrem = 300 + 0.06 * ( income - 38000.00 );
			
			//setting max value of healthPrem
			if ( healthPrem > 450.00 ) {
				healthPrem = 450.00;
			}
		}
		
		else if ( income > 22000.00 ) {
			healthPrem = 0.06 * ( income - 22000.00 );
			
			//setting max value of healthPrem
			if ( healthPrem > 300.00 ) {
				healthPrem = 300.00;
			}
		}


		//return value of healthPrem to function
		return healthPrem;
	}
	
	public double getAmount() {
		amount = computeAmount(); //computes the applicable healthPrem
		amount = Math.round( amount * 100.0 ) / 100.0; //rounding off to 2dp
		return amount;
	}
}