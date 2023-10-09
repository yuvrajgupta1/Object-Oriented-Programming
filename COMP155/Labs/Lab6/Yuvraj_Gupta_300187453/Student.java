public class Student implements Comparable<Student> {
	
	private String name;
	private int studentNumber;
	private int age;
	
	//parametrized constructor
	public Student( String name, int studentNumber, int age ) {
		
		this.name = name;
		this.studentNumber = studentNumber;
		this.age = age;
	}
	
	//accessor methods
	public String getName() { 
		
		return name;			//returns the Student name
	}
	public int getStudentNumber() { 
		
		return studentNumber;	// returns the student number
	}
	public int getAge() { 
		
		return age;				// returns the student age
	}
	
	//modification methods
	public void setName( String name ) { 
		
		this.name = name; 		// sets new value of name
	}
	public void setStudentNumber( int number ) { 
		
		studentNumber = number;	// sets new value of student number
	}
	public void setAge( int age ) { 
		
		this.age = age;			// sets new value of age
	}
	
	//checks if 2 students are equal
	public boolean equals( Student other ) {
		
		// checks if the other student is null
		if ( other == null ) {
			return false;
		}
		
		// compares all attributes of the student
		return this.name.equals ( other.name )
					&& this.studentNumber == other.studentNumber
							&& this.age == age;
	}
	
	//compares 2 student names
	public int compareTo( Student other ) {
		
		// returns value based on the string compareTo method
		return this.getName().compareTo( other.getName() );
	}
	
	//returns information of Student
	public String toString() { 
		
		return "Name: " + getName() + ", Student ID: " + getStudentNumber() + ", Age: " + getAge();
	}
}