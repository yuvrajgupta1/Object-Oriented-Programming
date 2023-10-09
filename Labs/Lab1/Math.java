class Math {

	//computes the sum of two values
	public static float add( float first, float second ) {
            
		//computes first + second and then returns it to the function
		return first + second;
	}
	
	//computes the sum of array
	public static float add( float[] arr ) {
		
        //variable declaration and intialization of type int and float
		int i = 0;
        float sum = (float) 0; //with casting to avoid precision loss
                
        //while loop to add each element of array
		while(i < arr.length){
			sum += arr[i]; //sum = sum + arr[i]
            i++; //i = i + 1
        }
                
		//returns the value of sum to function
		return sum;
	}
	
	//computes the mulpication of two values
	public static float multiply( float first, float second ) {
		
		//computes first * second and then returns it to the function
		return first * second;
	}
	
	//computes the mulpication of array
	public static float multiply( float[] arr ) {
		
		//Variable declaration and intialization of type int and float
		int i = 0;
		float ans = (float) 1; //with casting to avoid precision loss
                
		// while loop to multiply each element of array
		while(i < arr.length){
			ans *= arr[i]; // ans = ans *= arr[i]
			i++; // i = i + 1
		}
                
		//returns the value of ans to the function
		return ans;
	}
}