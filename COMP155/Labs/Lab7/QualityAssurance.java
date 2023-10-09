/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

public class QualityAssurance {
	
	
	//testing Point object
	@SuppressWarnings( "unchecked" )
	public static boolean[] Q1() {

		boolean [] answer = new boolean[4];
		LinkedStack linkedStack = new LinkedStack<>();
		for( int i = 0; i < 10; i ++ ) {
			linkedStack.push( i );
		}
		answer[0] = linkedStack.hasElement(8);
		answer[1] = !linkedStack.hasElement(-1);
		answer[2] = !linkedStack.hasElement(10);
		answer[3] = linkedStack.hasElement(4);
		return answer;
	}
	
	//testing the Account object
	@SuppressWarnings( "unchecked" )
	public static boolean[] Q2() {

		boolean [] answer = new boolean[4];
		ArrayStack linkedStack = new ArrayStack<>(5);
		for( int i = 0; i < 10; i ++ ) {
			linkedStack.push( i );
		}
		answer[0] = linkedStack.hasElement(8);
		answer[1] = !linkedStack.hasElement(-1);
		answer[2] = !linkedStack.hasElement(10);
		answer[3] = linkedStack.hasElement(4);
		return answer;
	}
}