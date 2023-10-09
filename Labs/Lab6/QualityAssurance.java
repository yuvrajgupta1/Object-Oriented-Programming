/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

public class QualityAssurance {
	
	
	//testing Point object
	public static boolean[] Q1() {

		boolean [] answer = new boolean[6];
		Student s1 = new Student("Opeyemi Adesina", 300172890, 26 );
		Student s2 = new Student("Olusegun Adesina", 300172890, 26 );
		answer[0] = !s1.equals( s2 );
		s2.setName( "Opeyemi Adesina" );
		s2.setStudentNumber( 300529682 );
		s1.setStudentNumber( 300529682 );
		answer[1] = s1.equals( s2 );
		answer[2] = s1.getName() == "Opeyemi Adesina";
		answer[3] = s2.getAge() == 26;
		s1.setAge( 35 );
		answer[4] = s1.getAge() == 35;
		answer[5] = s1.getStudentNumber() == 300529682;
		//answer[6] = s1.toString().equals("Name: Opeyemi Adesina, Student ID: 300529682, Age: 35");
		
		return answer;
	}
	
	//testing the Account object
	public static boolean[] Q2() {

		boolean [] answer = new boolean[5];
		Account a1 = new Account(300172890, "Opeyemi Adesina", 2000000.85 );
		Account a2 = new Account(300172820, "Olusegun Adesina", 200000.00 );
		answer[0] = !a1.equals( a2 );
		a2.setName( "Opeyemi Adesina" );
		a2.setAccountNumber( 300529682 );
		a1.setAccountNumber( 300529682 );
		a2.setBalance(2000000.85);
		answer[1] = a1.equals( a2 );
		answer[2] = a1.getName() == "Opeyemi Adesina";
		answer[3] = a2.getBalance() == 2000000.85;
		answer[4] = a1.getAccountNumber() == 300529682;
		//answer[5] = a2.toString().equals("Accout number: 300529682, Name: Opeyemi Adesina, Balance: 2000000.85");
		
		return answer;
	}
	
	//testing Student.compareTo(...)
	public static boolean[] Q3() {

		boolean [] answer = new boolean[4];
		Student s1 = new Student("Opeyemi Adesina", 300172890, 26 );
		Student s2 = new Student("Olusegun Adesina", 300172890, 26 );
		answer[0] = s2.compareTo(s2) == 0;
		s1.setName("Olusegun Adesina");
		answer[1] = s1.compareTo(s2) == 0;
		s1.setName("Opeyemi Adesina");
		answer[2] = s1.compareTo(s2) > 0;
		answer[3] = s2.compareTo(s1) < 0;
		
		return answer;
	}
	
	//testing Account.compareTo(...)
	public static boolean[] Q4() {

		boolean [] answer = new boolean[4];
		Account a1 = new Account(300172890, "Opeyemi Adesina", 2000000.85 );
		Account a2 = new Account(300172820, "Olusegun Adesina", 200000.00 );
		answer[0] = a2.compareTo(a2) == 0;
		a1.setAccountNumber(300172820);
		answer[1] = a1.compareTo(a2) == 0;
		a1.setAccountNumber(300172890);
		answer[2] = a1.compareTo(a2) > 0;
		answer[3] = a2.compareTo(a1) < 0;
		
		return answer;
	}
}