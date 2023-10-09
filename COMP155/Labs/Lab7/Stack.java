public interface Stack<E> {
	void push(E element);
	E pop();
	E peek();
	boolean isEmpty();
	//walks through the stack and displaying the elements on the stack - check the given output
	void display(); 
	//return true whenever element is found on the stack, otherwise it returns false.
	boolean hasElement( E element ); 
}