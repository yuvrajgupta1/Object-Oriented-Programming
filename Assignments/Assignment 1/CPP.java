/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian.payroll;

public class CPP extends Deduction {
	
	public CPP( Employee employee ) {
		super( employee );
	}
	
	public double computeAmount() {
		
		double income = employee.getIncome();
		
		// variable declaration and initialization
		double cpp = income * 0.0525;
		
		// setting max value of CPP
		if ( cpp > 2898.00 ) {
			cpp = 2898.00;
		}
		
		//return the value of CPP to function
		return cpp;
	}
	
	public double getAmount() {
		amount = computeAmount(); //computes the applicable CPP
		amount = Math.round( amount * 100.0 ) / 100.0; //rounding off to 2dp
		return amount;
	}
}