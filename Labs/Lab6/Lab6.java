public class Lab6 {
	
	public static void main( String [] args ) {
		
		Student s1 = new Student("Opeyemi Adesina", 300172890, 26 );
		Student s2 = new Student("Olusegun Adesina", 300172890, 26 );
		Student s3 = new Student("Adewale Ayuba", 300172890, 26 );
		Student s4 = new Student("Nick Rock", 300172890, 26 );
		
		
		Student [] students = new Student[4];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		
		System.out.println("\nBEFORE - UNSORTED!!!");
		Utils.display( students );
		Utils.selectionSort( students );
		System.out.println("\nAFTER - SORTED!!!");
		Utils.display( students );
		
		
		
		Account a1 = new Account(300172890, "Opeyemi Adesina", 2000000.85 );
		Account a2 = new Account(300172820, "Olusegun Adesina", 200000.00 );
		Account a3 = new Account(300152820, "Oreyemi Ayuba", 1500.00 );
		Account a4 = new Account(300152220, "Okesina Adetunde", 1500.00 );
		Account a5 = new Account(300152820, "Nicholas Rexwood", 15000.00 );
		
		Account [] accounts = new Account[5];
		accounts[0] = a1;
		accounts[1] = a2;
		accounts[2] = a3;
		accounts[3] = a4;
		accounts[4] = a5;
		
		
		System.out.println("\nBEFORE - UNSORTED!!!");
		Utils.display( accounts );
		Utils.selectionSort( accounts );
		System.out.println("\nAFTER - SORTED!!!");
		Utils.display( accounts );
		
		
		System.out.println("\n");
		boolean[] test = GradeLab.test();
		GradeLab.gradeLab( test );
	}
}