/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian.payroll;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class Employee {
	
	//these define attributes of an employee
	private double income;
	private String name;
	private String dob;
	private int serialNumber;
	private String sex;
	private String maritalStatus;
	private String provinceOfResidence;
	
	//Each instance of Deduction will be one of the following FederalTax, ProvincialTax, EI, or CPP
	List<Deduction> deductions = new ArrayList<Deduction>();
	
	public Employee() {
		
		income = 0;
		name = null;
		dob = null;
		serialNumber = 0;
		sex = null;
		maritalStatus = null;
	}
	
	public Employee( double income, String name, String dob, int serialNumber, String sex, String maritalStatus, List<Deduction> deductions ) {
		
		this.income = income;
		this.name = name;
		this.dob = dob;
		this.serialNumber = serialNumber;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.deductions = deductions;
	}
	
	//Setter methods are defined as follow
	public void setIncome( double income ) {
		this.income = income;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public void setDob( String dob ) {
		this.dob = dob;
	}
	
	public void setSerialNumber( int serialNumber ) {
		this.serialNumber = serialNumber;
	}
	
	public void setSex( String sex ) {
		this.sex = sex;
	}
	
	public void setMaritalStatus( String maritalStatus ) {
		this.maritalStatus = maritalStatus;
	}
	
	public void setDeductions(List<Deduction> deductions ) {
		this.deductions = deductions;
	}
	
	public void setProvince( String province ) {
		this.provinceOfResidence = province;
	}
	
	//Getter methods are defined as follow
	public double getIncome() {
		return income;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public List<Deduction> getDeductions() {
		return deductions;
	}
	
	public String getProvince() {
		return this.provinceOfResidence;
	}

	public double getProvincialTaxAmount(){
		
		for( Deduction deduction : deductions ) {
			if( deduction instanceof GovernmentTax && deduction.isProvincial() ) {
				return deduction.getAmount();
			}
		}
		return 0.0;
	}

	public double getFederalTaxAmount(){
		
		for( Deduction deduction : deductions ) {
			if( deduction instanceof GovernmentTax && !deduction.isProvincial() ) {
				return deduction.getAmount();
			}
		}
		return 0.0;
	}

	public double getCPP(){
		
		for( Deduction deduction : deductions ) {
			if( deduction instanceof CPP ) {
				return deduction.getAmount();
			}
		}
		return 0.0;
	}

	public double getHealthPremium(){
		
		for( Deduction deduction : deductions ) {
			if( deduction instanceof HealthPremium ) {
				return deduction.getAmount();
			}
		}
		return 0.0;
	}

	public double getEI(){
		
		for( Deduction deduction : deductions ) {
			if( deduction instanceof EI ) {
				return deduction.getAmount();
			}
		}
		return 0.0;
	}
	
	public double computeNetIncome() {
		double netIncome = income - computeDeductions();
		return Math.round( netIncome * 100.0 ) / 100.0;
	}
	
	//computes and returns all deductions of the employee. Useful in computing net income
	public double computeDeductions() {
		
		double totalDeduction = 0.0;
		for( Deduction deduction : deductions ) {
			totalDeduction += deduction.getAmount();
		}
		totalDeduction = Math.round( totalDeduction * 100.0 ) / 100.0; //rounding off to 2dp
		return totalDeduction;
	}
	
	//newly introduced
	public boolean equals( Employee other ) {
		
		if( other != null ) {
			return name.equals( other.name ) &&
				income == other.income &&
					dob.equals( other.dob ) &&
						serialNumber == other.serialNumber &&
							maritalStatus.equals( other.maritalStatus ) &&
								provinceOfResidence.equals( other.provinceOfResidence ) && 
									sex.equals(other.sex);
		}
		return false;
	}

	//This formats monies for presentation purposes
	private String formatCurrency( double amount ) {
		DecimalFormat df = new DecimalFormat("$###,###,###.##");
		return df.format(amount);
	}
	
	public String shortString() {
		
		return "ID: "+getSerialNumber() +"| \t"+ 
			"Name: " + getName() +"| \t"+ 
			"Sex: " + getSex() +"| \t"+ 
			"DOB: " + getDob() +"| \t"+ 
			"Status: " + getMaritalStatus() +"| \t"+ 
			"Province: " + getProvince() +"| \t"+  
			"Gross Income: " + formatCurrency( getIncome() ) +"| \t"+
			"Deductions: " + formatCurrency( computeDeductions() ) +"| \t"+ 
			"Net Income: " + formatCurrency( computeNetIncome() );
	}

	public String displayDeductions() {
		
		return " (FTax: "+formatCurrency(getFederalTaxAmount()) +", "+ 
			"PTax: " + formatCurrency(getProvincialTaxAmount()) +", "+  
			"CPP: " + formatCurrency( getCPP() ) +", "+
			"EI: " + formatCurrency( getEI() ) +", "+ 
			"HP: " + formatCurrency( getHealthPremium() )+")";
	}

	public String toString() {
		
		return "ID: "+getSerialNumber() +"| \t"+ 
			"Province: " + getProvince() +"| \t"+  
			"Gross Income: " + formatCurrency( getIncome() ) +"| \t"+
			"Deductions: " + formatCurrency( computeDeductions() ) + displayDeductions() +"| \t"+ 
			"Net Income: " + formatCurrency( computeNetIncome() );
	}
}