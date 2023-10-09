/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package canadian.payroll;

import java.util.List;

public class OverallTax extends Deduction {
	
	private GovernmentTax provincialTax, federalTax;
	public OverallTax( Employee employee, GovernmentTax provincialTax ) {
		super( employee );
		this.provincialTax = provincialTax;
		federalTax = new GovernmentTax( employee, "federal" );
	}
	
	public double computeAmount() {
		return provincialTax.getAmount() + federalTax.getAmount();
	}
	
	public double getAmount() {
		amount = computeAmount(); //computes the applicable overall taxes
		amount = Math.round( amount * 100.0 ) / 100.0; //rounding off to 2dp
		return amount;
	}
}