/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/
package tracker.test;

public class GradeLab {
	
	private static double points( int index ) {
		
		//returns approriate grade points based on the test index
		switch( index ) {
			case 0 : return 13;
			case 1 : return 15;
			case 2 : return 15;
			case 3 : return 20;
			case 4 : return 27;
			default: return 0;
		}
	}

	//this method computes students grade for this lab...
	public static void grade( boolean [] test ) {
		
		boolean flag = true;
		double totalPoints = 0;
		for( int i = 0; i < test.length; i++ ) {
			double points = Math.round( points( i ) * 100.0 ) / 100.0;
			if(test[i] == true ) {
				System.out.println("Test "+ i +" (Q"+(i+1)+") passed. [Alloted point(s): "+points+"]");
				totalPoints += points( i );
			} else {
				System.out.println("Test "+ i +" (Q"+(i+1)+") failed. [Alloted point(s): "+points+"]");
				flag = false;
			}
		}
		
		if( flag ) {
			System.out.println("All tests are successful.");
		} else {
			System.out.println("Not all tests are successful.");
		}
		System.out.println("Total points earned in this lab: "+  Math.round( totalPoints * 100.0) / 100.0 +" points ");
	}
}