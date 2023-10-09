public class GradeLab {
	
	private static double points( int index ) {
		
		//returns approriate grade points based on the test index
		switch( index ) {
			case 0 : return 25;
			case 1 : return 25;
			case 2 : return 20;
			case 3 : return 30;
			case 4 : return 7.5;
			case 5 : return 7.5;
			case 6 : return 20;
			case 7 : return 15;
			default: return 0;
		}
	}

	//this method computes students grade for this lab...
	public static void gradeLab( boolean [] test ) {
		
		boolean flag = true;
		double totalPoints = 0, overallPoints = 0;
		for( int i = 0; i < test.length; i++ ) {
			double points = points( i );
			if(test[i] == true ) {
				System.out.println("test "+ i +" passed.");
				totalPoints += points;
			} else {
				System.out.println("test "+ i +" failed.");
				flag = false;
			}
			overallPoints += points;
		}
		
		if( flag ) {
			System.out.println("All tests are successful.");
		} else {
			System.out.println("Not all tests are successful.");
		}

		System.out.println("Total points earned in this lab: ["+ totalPoints +"/"+overallPoints+"]" );
	}
	
	
	public static boolean evaluateQuestion( boolean [] questions ) {
		
		boolean answer = questions[0];
		for( boolean question : questions ) {
			answer = answer && question;
		}
		
		return answer;
	}
	
	public static boolean[] test() {
		
		boolean[] test = new boolean[2];
		
		test[0] = evaluateQuestion( QualityAssurance.Q1() );
		test[1] = evaluateQuestion( QualityAssurance.Q2() );
		
		return test;
	}
} 