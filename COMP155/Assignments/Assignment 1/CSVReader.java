/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian.file;

import java.io.*;
import canadian.payroll.*;
import java.util.*;
import canadian.Utility;


public class CSVReader {

	static Map<Integer, Employee> map = new Hashtable<Integer, Employee>();
	
	//strips any string off its double quotes whenever present
	private static String removeQuotes( String str ) {
		
		int length = str.length();
		if( length >= 2 && str.startsWith("\"") && str.endsWith("\"") ) {
			str = str.substring( 1, length - 1 );
		}
		return str;
	}
	
	
	
	//Converts a CSV file into its Hashtable equivalent
	public static Map<Integer, Employee> getEmployees( String fileName ) {
		
		String line = "", splitChar = ",";
		Map<Integer, Employee> map = new Hashtable<Integer, Employee>();
		try {
			FileReader file = new FileReader( fileName );
			BufferedReader reader = new BufferedReader( file );
			line = reader.readLine();
			while( line != null ) {
				
				//Retrieving and spliting each line into its respective fields 
				String [] empStr = line.split( splitChar );
				String serialNumber = empStr[0],
					name = empStr[1] + empStr[2],
					income = empStr[3] + empStr[4],
					sex = empStr[5],
					dob = empStr[6],
					maritalStatus = empStr[7],
					province = empStr[8];
				
				//Instantiating employee object per line of the employee list
				Employee employee = new Employee();
				employee.setSerialNumber( Integer.parseInt( serialNumber ) );
				employee.setName( removeQuotes( name ) );
				income = removeQuotes( income );
				employee.setIncome( Double.parseDouble( income.substring( 1, income.length() ) ) );
				employee.setSex( sex );
				employee.setDob( dob );
				employee.setMaritalStatus( maritalStatus );
				employee.setProvince( province );
				
				//computing the deductions
				employee.setDeductions( Utility.computeDeductions( employee ) );
				map.put( employee.getSerialNumber(), employee );
				line = reader.readLine();
			}
		} catch( Exception ex ) {
			System.out.println("File not found! I am here!!!");
			System.out.println(ex);
		}
		return map;
	}
}