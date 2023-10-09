public class LinkedStack<E> implements Stack<E> {
	
	//definition of an inner class
	private static class Elem<E> {
		private E value;
		private Elem<E> next;
		public Elem( E value, Elem<E> next ) {
			this.value = value;
			this.next = next;
		}
		public void setValue( E value ) { this.value = value; }
		public void setNext( Elem<E> next ) { this.next = next; }
		public E getValue() { return value; }
		public Elem<E> getNext() { return next; }
	}
	
	private Elem<E> top;
	public boolean isEmpty() { return top == null; }
	public void push( E obj ) {
		top = new Elem<E>( obj, top );
	}
	public E peek() { return top.value; }
	public E pop() { 
		E saved = top.value;
		top = top.next;
		return saved;
	}
	
	public boolean hasElement( E element ) {
		Elem<E> temp = top;						// temporary variable to iterate over the stack
		if ( ! isEmpty() ) {					// checks if the stack is not empty
			while ( temp != null ) {			// loop runs till the value of temp is not null
				if ( element == temp.value ) {	// if it founds the element it returns true
					return true;
				} else {						// else move on to the next element
					temp = temp.next;
				}
			}
		}
		return false;							// returns false if value is not in the stack
	}
	
	public void display() {
		if( ! isEmpty() ) {
			Elem<E> temp = top;					// temporary variable to iterate over the stack
			int i = 0;							// index variable
			while ( temp != null ) {			// loop runs till temp is not null
				System.out.println( "element[" + i + "] = " + temp.value );	// print values in a stack
				i++;							// adding 1 to index variable
				temp = temp.next;				// moving on to the next element
			}
			
		}
	}
	
}