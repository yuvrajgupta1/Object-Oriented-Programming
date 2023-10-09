/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


import canadian.file.CSVReader;
import canadian.payroll.Employee;
import canadian.Utility;

import java.util.*;

public class TaxTest {

	//An entry point for the program execution
	public static void main( String [] args ) {
		
		String fileName = "salaries.csv";
		
		long start, stop, elapsed;
		start = System.currentTimeMillis(); //timer is started
		Map<Integer, Employee> map = CSVReader.getEmployees( fileName );
		Utility.leastPaidEmployees(map);
		Utility.highestPaidEmployees(map);
		stop = System.currentTimeMillis(); //timer is stopped
		elapsed = stop - start;
		System.out.println("Time taken : " +elapsed+" (ms)");

		boolean[] test = QualityAssurance.test();
		Utility.gradeLab( test );
	}
}