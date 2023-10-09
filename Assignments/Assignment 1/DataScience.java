/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/


package canadian;

import canadian.payroll.*;
import java.util.*;


public class DataScience {
	
	//argument the map of employees for the target province
	public static Employee leastPaidEmployee( String province, Map<Integer, Employee> map ) {
		
		//INSERT YOUR CODE HERE - study how allEmployees(...) is being implemented
		map = allEmployeesOf( province, map );
		if( map != null ) {
			try{
				// converting map to ArrayList
				ArrayList<Employee> values = new ArrayList<>(map.values());
				
				// variable intialization
				Employee e1 = (Employee) values.get(0); //gets value at index 0 of ArrayList
				
				//loop to find the min value
				for(int i = 1; i < values.size(); i++) {
					try{
						// condition for min
						if (e1.getIncome() > values.get(i).getIncome()) {
							e1 = values.get(i);
						}
					}
					catch(Exception ex){};
					
					}
				return e1;
			}
			catch(Exception ex){};
		}
		
		return null;
	}

	//argument the map of employees for the target province
	public static Employee highestPaidEmployee( String province, Map<Integer, Employee> map ) {
		
		//INSERT YOUR CODE HERE - see how allEmployees(...) is being implemented below. You may even reuse the code as well
		map = allEmployeesOf( province, map );
		if( map != null ) {
			try{
				// converting map to ArrayList
				ArrayList<Employee> values = new ArrayList<>(map.values());
	
				// variable intitalization
				Employee e1 = (Employee) values.get(0); //gets value at index 0 of ArrayList
				
				//loop to find the max value
				for(int i = 1; i < values.size(); i++) {
					try{
						// condition for max
						if (e1.getIncome() < values.get(i).getIncome()) {
							e1 = values.get(i);
						}
					}
					catch(Exception ex){};
					
					}
				return e1;
			}
			catch(Exception ex){};
		}
		
		return null;
	
	}

	//computes a list of all employees by their province of residence
	public static Map<Integer, Employee> allEmployeesOf( String province, Map<Integer, Employee> map ) {
		
		province = Utility.formatProvince( province );
		Map<Integer, Employee> empMap = new Hashtable<Integer, Employee>();
		for( Map.Entry<Integer, Employee> entry : map.entrySet() ) {
			
			int key = entry.getKey();
			Employee value = ( Employee ) entry.getValue();
			if( value.getProvince().equals( province ) ) {
				empMap.put( key, value );
			}
		}
		return empMap; 
	}
}