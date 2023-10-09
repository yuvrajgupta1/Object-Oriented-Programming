public class TestStack {
	
	public static void main( String [] args ) {
		
		Stack<Integer> linkedStack = new LinkedStack<>();
		
		long start, stop, elapsed, loopSize = 100000;
		start = System.currentTimeMillis();
		for( int i = 0; i < loopSize; i ++ ) {
			linkedStack.push( i );
		}
		stop = System.currentTimeMillis();
		elapsed = stop - start;
		System.out.println("LinkedStack (time taken) : " + elapsed +" (ms)");
		
		Stack<Integer> stack = new ArrayStack<>( 5 );
		start = System.currentTimeMillis();
		for( int i = 0; i < loopSize; i ++ ) {
			stack.push( i );
		}
		stop = System.currentTimeMillis();
		elapsed = stop - start;
		System.out.println("ArrayStack (time taken) : " + elapsed +" (ms)");
		
		
		
		linkedStack = new LinkedStack<>();
		for( int i = 0; i < 5; i ++ ) {
			linkedStack.push( i );
		}
		System.out.println("\nDisplaying LinkedStack!");
		linkedStack.display();
		
		stack = new ArrayStack<>( 5 );
		for( int i = 0; i < 5; i ++ ) {
			stack.push( i );
		}
		System.out.println("\nDisplaying ArrayStack!");
		stack.display();
		
		System.out.println("\n");
		boolean[] test = GradeLab.test();
		GradeLab.gradeLab( test );
	}
}