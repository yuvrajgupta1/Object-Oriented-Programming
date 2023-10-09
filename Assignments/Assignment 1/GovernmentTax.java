/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian.payroll;

import java.util.*;
import canadian.*;

public class GovernmentTax extends Deduction {
	
	boolean isProvincial = false;
	public static class TaxUtil {
		
		public static Map<Integer, TaxCategory> getEmployeeCategories( String provinceOrFederal ) {
			
			provinceOrFederal = Utility.formatProvince( provinceOrFederal.toLowerCase() );
			switch( provinceOrFederal ) {
				case "AB" : return alberta();
				case "BC" : return britishColumbia();
				case "MB" : return manitoba();
				case "NB" : return newBrunswick();
				case "NS" : return novaScotia();
				case "ON" : return ontario();
				case "SK" : return saskatchewan();
				default : return federal();
			}
		}
		
		//declares the categories for the province of Manitoba
		public static Map<Integer, TaxCategory> manitoba() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(10.8, 0, 33723);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(12.75, 33723.01, 72885);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(17.4, 72885.01, 10000000);
				categories.put( 3, cat3 );
			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of Alberta
		public static Map<Integer, TaxCategory> alberta() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(10, 0, 131220);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(12, 131220.01, 157464);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(13, 157464.01, 209952);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(14, 209952.01, 314928);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(15, 314928.01, 10000000);
				categories.put( 5, cat5 );	
			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of British Columbia
		public static Map<Integer, TaxCategory> britishColumbia() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(5.06, 0, 42184);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(7.7, 42184.01, 84369);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(10.5, 84369.01, 96866);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(12.29, 96866.01, 117623);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(14.7, 117623.01, 159483);
				categories.put( 5, cat5 );
				TaxCategory cat6 = new TaxCategory(16.8, 159483.01, 222420);
				categories.put( 6, cat6 );
				TaxCategory cat7 = new TaxCategory(20.5, 222420.01, 10000000);
				categories.put( 7, cat7 );
			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of New Brunswick
		public static Map<Integer, TaxCategory> newBrunswick() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(9.68, 0, 43835);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(14.82, 43835.01, 87671);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(16.52, 87671.01, 142534);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(17.84, 142534.01, 162383);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(20.3, 162383.01, 10000000);
				categories.put( 5, cat5 );
			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of Nova Scotia
		public static Map<Integer, TaxCategory> novaScotia() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(8.79, 0, 29590);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(14.95, 29590.01, 59180);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(16.67, 59180.01, 93000);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(17.5, 93000.01, 150000);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(21, 150000.01, 10000000);
				categories.put( 5, cat5 );
			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of Ontario
		public static Map<Integer, TaxCategory> ontario() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(5.05, 0, 44740);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(9.15, 44740.01, 89482);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(11.16, 89482.01, 150000);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(12.16, 150000.01, 220000);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(13.16, 220000.01, 10000000);
				categories.put( 5, cat5 );

			} catch( Exception e ) {}
			
			return categories;
		}

		//declares the categories for the province of saskatchewan
		public static Map<Integer, TaxCategory> saskatchewan() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(10.5, 0, 45677);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(12.5, 45677.01, 130506);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(13.16, 130506.01, 10000000);
				categories.put( 3, cat3 );
			} catch( Exception e ) {}
			
			return categories;
		}
		
		//declares the categories for the federal government
		public static Map<Integer, TaxCategory> federal() {
			
			HashMap<Integer, TaxCategory> categories = new HashMap<Integer, TaxCategory>();
			try {
				TaxCategory cat1 = new TaxCategory(15, 0, 49020);
				categories.put( 1, cat1 );
				TaxCategory cat2 = new TaxCategory(20.5, 49020.01, 98040);
				categories.put( 2, cat2 );
				TaxCategory cat3 = new TaxCategory(26, 98040.01, 151978);
				categories.put( 3, cat3 );
				TaxCategory cat4 = new TaxCategory(29, 151978.01, 216511);
				categories.put( 4, cat4 );
				TaxCategory cat5 = new TaxCategory(33, 216511.01, 10000000);
				categories.put( 5, cat5 );
			} catch( Exception e ) {}
			
			return categories;
		}
	}
	
	private Map<Integer, TaxCategory> categories;
	public GovernmentTax( Employee employee, String provinceOrFederal ) {
		
		super( employee );
		String province = provinceOrFederal;
		if( !( provinceOrFederal.equals("federal") || provinceOrFederal.equals( "fed" ) ) ) {
			province = employee.getProvince();
			isProvincial = true;
		}
		this.categories = TaxUtil.getEmployeeCategories( province );
	}
	
	public double computeAmount() {
		
		double income = employee.getIncome();
		double tax = 0;
		
		//loop to go through each tax category
		for ( Map.Entry<Integer, TaxCategory> entry : categories.entrySet() ) {
			
			//variable declaration and intialization for each tax category
			double upperBound = entry.getValue().getUpperBound();
			double lowerBound = entry.getValue().getLowerBound();
			double percentage =  entry.getValue().getPercentage();
			
			//check to see if income is between upper bound & lower bound
			if ( income < upperBound && income > lowerBound ) {
				
				tax += (income - lowerBound) * percentage / 100;
				return tax;
				
			} else {
				
				tax += (upperBound - lowerBound) * percentage / 100;
			
			}
		}
		
		return 0.0;
		
	}
	
	public double getAmount() {
		return Math.round( computeAmount() * 100.0 ) / 100.0;
	}

	public boolean isProvincial() {
		return isProvincial;
	}
}