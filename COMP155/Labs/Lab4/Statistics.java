import java.util.*;

public class Statistics {
	
	//computes the average of the set of values passed as argument
	public static double mean( double [] values ) {

		// variable declaration and intilization
		double mean = 0;
		
			// check to see that array is not empty
			if(values.length != 0){
				
				// loop to add all values of the array
				for( int i = 0; i < values.length; i++ ) {
				
					mean += values[i]; // mean = mean + values[i]
					
				}
				
				// divide by array length to get mean
				mean /= values.length;	//mean = mean / values.length
			
			}
			// returns value to the function after calling round method
			return round(mean);
		
		
		
	}

	//computes the median of a given set of values
	//return an array of median values
	public static double[] median( double [] values ) {
		
		Arrays.sort( values ); //sorts the input value

		// array declaration and intialization
		double [] median = new double [] {0};
		
		// variable declaration and intialization
		int i = values.length;
		
		// check if i is divisible by 2
		if( i % 2 == 0 ) {
			
			// i = i / 2
			i /= 2;
			
			// index of array starts at 0, hence to get the correct result
			// we need to subtract 1 from i so as to get the correct value
			median[0] = ( values[i - 1] + values[i] ) / 2;
			
			return median;
			
		} else {
			
			i = ( i + 1 ) / 2;
			
			// index of array starts at 0, hence to get the correct result
			// we need to subtract 1 from i so as to get the correct value
			median[0] = values[i - 1];
			
			// returns value to the function
			return median;
		
		}

	}

	//returns the variable with highest frequency
	public static double mode( double [] values ) {
		
		// variable declaration and initialization
		double value = values[0];
		int maxCount = 0;
		
		// loop to check if 2 numbers are equal
		for ( int i = 0; i < values.length; i++ ) {
			
			// counter to know how many times the same value occurred
			int counter = 0;
			
			
			for( int j = 0; j < values.length; j++) {
				
				if ( values[i] == values[j] ){
					counter++; // counter = counter + 1
				}
				
				if( counter > maxCount ){
					maxCount = counter;
					value = values[i];
					
				}
			}
		}

		return value;
	}

	//return values must be in 2 decimal places
	//computes population variance
	public static double popVariance( double [] values ) {

		// invokes mean method and is stored to mean1 variable
		double mean1 = mean(values);
		// variable declaration and intialization
		double popVariance = 0.0;
		
		// loop to add each expression to popVariance
		for( int i = 0; i < values.length; i++) {
			popVariance += ((values[i] - mean1) * (values[i] - mean1));
		}
		
		// divide popVariance by array size
		popVariance /= values.length; // popVariance = popVariance / values.length
		
		// returns value to the function after calling round method
		return round( popVariance );

		
	}

	//computes population standard deviation
	public static double popStdev( double [] values ) {

		// invokes popVariance method and is stored to  popStdev
		double popStdev = popVariance(values);
		
		// taking sqrt of popStdev 
		popStdev = Math.sqrt(popStdev);
		
		// returns value to the function after calling round method
		return round( popStdev );
	}
	
	// rounds off value to 2 decimal places
	public static double round (double value){
		
		double value1 = Math.round( value * 100.0 ) / 100.0;
		return value1;
		
	}
	private static double points( int index ) {
		
		//returns approriate grade points based on the test index
		switch( index ) {
			case 0 : return 0;
			case 1 : return 10;
			case 2 : return 15;
			case 3 : return 15;
			case 4 : return 7.5;
			case 5 : return 7.5;
			case 6 : return 20;
			case 7 : return 15;
			default: return 0;
		}
	}

	//this method computes students grade for this lab...
	private static void gradeLab( boolean [] test ) {
		
		boolean flag = true;
		double totalPoints = 0;
		for( int i = 0; i < test.length; i++ ) {
			if(test[i] == true ) {
				System.out.println("test "+ i +" passed.");
				totalPoints += points( i );
			} else {
				System.out.println("test "+ i +" failed.");
				flag = false;
			}
		}
		
		if( flag ) {
			System.out.println("All tests are successful.");
		} else {
			System.out.println("Not all tests are successful.");
		}

		System.out.println("Total points earned in this lab: "+ totalPoints );
	}

	public static void main( String [] args ) {
		
		boolean[] test = new boolean[8];
		
		//testing the mean method
		double[] values = new double[]{};
		test[0] = ( mean(values) == 0.0 );
		values = new double[] {1, 2, 3, 5, 6, 7, -8, 20, 25, 60, 75, 28, 43};
		test[1] = ( mean(values) == 20.54 ); 
		test[2] = ( mean ( median( values ) ) == 7.0 );
		values = new double[] {1, 2, 3, 5, 6, 7, -8, 20, 25, 60, 75, 28};
		test[3] = ( mean ( median( values ) ) == 6.5 );
		test[4] = ( mode( values ) == -8 );
		values = new double[] {1, 2, 3, 5, 6, 7, -8, 20, 25, 60, 75, 28, 28};
		test[5] = ( mode( values ) == 28 );
		test[6] = ( popVariance(values) == 547.78 );
		test[7] = ( popStdev(values) == 23.4 );
		
		
		//printing tests result
		gradeLab( test );
	}
}