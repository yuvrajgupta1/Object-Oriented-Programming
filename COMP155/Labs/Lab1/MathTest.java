class MathTest {
	
	public static void print( float result ) {
		//prints result with new line
		System.out.println("Result: "+result);
	}
	
	public static void main(String [] args ) {
		
		//declares a and b of types float
		float a;
		float b;
		
		//assigns values to a and b (but with casting to avoid loss of precision)
		a = (float) 10.6;
		b = (float) 25.0;
		print(Math.add(a, b));
		print(Math.multiply(a, b));
		
		//declares and initializes an array
		float[] arr;
		arr = new float[5];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;
		print(Math.add(arr));
		print(Math.multiply(arr));
		
		//uses short circuit to define and initialize array
		float[] brr;
		brr = new float[] {2, 3, 4, 5, 6};
		print(Math.add(brr));
		print(Math.multiply(brr));
		
	}
}