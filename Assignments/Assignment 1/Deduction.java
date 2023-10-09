/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian.payroll;


public abstract class Deduction {
	
	//declaration of class attributes
	protected double amount;
	protected Employee employee = new Employee();
	public Deduction( Employee employee ) {
		this.employee = employee;
	}
	
	//abstract methods enforces subclass implementations
	abstract double getAmount();
	public boolean isProvincial() {
		return false;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee( Employee employee ) {
		this.employee = employee;
	}
	
	abstract double computeAmount();
}