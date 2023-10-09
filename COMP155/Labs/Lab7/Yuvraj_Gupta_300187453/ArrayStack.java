public class ArrayStack<E> implements Stack<E> {
	private E[] elements;
	private int top;
	private static final int increment = 5;
	@SuppressWarnings( "unchecked" )
	public ArrayStack( int capacity ) {
		elements = (E[]) new Object[ capacity ];
		top = 0;
	}
	
	@SuppressWarnings( "unchecked" )
	public void push( E element ) {
		int capacity = elements.length;
		if( top == capacity ) {
			E[] temp = (E[]) new Object[ capacity + increment ];
			System.arraycopy( elements, 0, temp, 0, top );
			elements = temp;
		}
		elements[top++] = element;
	}
	
	public E pop() {
		E element = null;
		if( !isEmpty() ) {
			element = elements[top - 1];
			elements[top - 1] = null;
			top--;
		}
		return element;
	}
	
	public E peek() { return elements[top]; }
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public int size() {
		return elements.length;
	}
	
	public void display() {
		if( ! isEmpty() ) {					// checks if the stack is not empty
			int temp = top - 1;				// temporary variable to iterate over the stack
			int i = 0;						// index variable
			while ( temp >= 0 ) {			// while loop to check when temp gets to 0
				System.out.println("element[" + i + "] = " + elements[temp] );	// prints stack
				i++;						// add 1 to index variable
				temp--;						// decrement temporary variable
			}
			
		}
	}
	
	public boolean hasElement( E element ) {
		
		int temp = top - 1;					// temporary variable to iterate over the stack
		while( temp >= 0 ) {				// while loop to check when temp gets to 0
			if ( element == elements[temp] ) {	// if element is found it returns true
				return true;
			} else {						// else the value of temp decreases by 1
				temp--;
			}
		}

		
		return false;
	}
}
