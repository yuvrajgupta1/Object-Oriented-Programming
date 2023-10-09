class Test {
	
	//CASE 1
	static void swap(MyInteger a, MyInteger b) {
		//INSERT YOUR CODE HERE - CASE 1
		MyInteger temp = new MyInteger(a.getValue());	//temporary variable for swapping & value of a gets stored in temp
		a.setValue(b.getValue());						// value of b gets stored in a
		b.setValue(temp.getValue());						// value of temp gets stored in b

		}
	
	//CASE 2
	static void swap(Integer a, Integer b) {
		//INSERT YOUR CODE HERE - CASE 2
		
		Integer temp;			//temporary variable for swapping
		temp = a;				// value of a gets stored in temp
		a = b;					// value of b gets stored in a
		b = temp;				// value of temp gets stored in b

	}
	
	//CASE 3
	static void swap(int a, int b) {
		//INSERT YOUR CODE HERE - CASE 3
		
		int temp;			//temporary variable for swapping
		temp = a;			// value of a gets stored in temp
		a = b;				// value of b gets stored in a
		b = temp;			// value of temp gets stored in b
	}
	
	//CASE 4
	static void swap(int [] arr ) {
		//INSERT YOUR CODE HERE - CASE 4
		
		int temp;			//temporary variable to swap
		temp = arr[0]; 		//value of arr[0] gets stored in temp
		arr[0] = arr[1];	//value of arr[1] gets stored in arr[0]
		arr[1] = temp;		//value of temp gets stored in arr[1]
	}
	
	static void printHeader( int caseID ) {
		
		System.out.println("\n.....................................................");
		System.out.println("........................CASE " +caseID+".......................");
		System.out.println(".....................................................");
	}
	
	public static void main( String [] args ) {
		
		//CASE 1
		MyInteger a, b;
		a = new MyInteger(5);
		b = new MyInteger(10);
		printHeader(1);
		System.out.println("Before: a = " + a.getValue() + " and b = "+ b.getValue());
		swap(a, b);
		System.out.println("After: a = " + a.getValue() + " and b = "+ b.getValue());
		
		//CASE 2
		Integer c, d;
		c = new Integer(5);
		d = new Integer(10);
		printHeader(2);
		System.out.println("Before: c = " + c + " and d = "+ d );
		swap(c, d);
		System.out.println("After: c = " + c + " and d = "+ d );
		
		//CASE 3
		int e, f;
		e = 5;
		f = 10;
		printHeader(3);
		System.out.println("Before: e = " + e + " and f = "+ f );
		swap(e, f);
		System.out.println("After: e = " + e + " and f = "+ f );
		
		//CASE 4
		int[] arr;
		arr = new int[2];
		arr[0] = 5;
		arr[1] = 10;
		printHeader(4);
		System.out.println("Before: arr[0] = " + arr[0] + " and arr[1] = "+ arr[1] );
		swap(arr);
		System.out.println("After: arr[0] = " + arr[0] + " and arr[1] = "+ arr[1] );
	}
}