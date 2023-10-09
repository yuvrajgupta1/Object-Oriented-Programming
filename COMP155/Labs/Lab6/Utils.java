public class Utils {
	
	public static <E> void display( E[] xs ) {
		for(int i = 0; i < xs.length; i++ ) {
			System.out.println( xs[i] );
		}
	}
	
	public static <T extends Comparable<T>> void selectionSort( T[] xs ) {
		
		for( int i = 0; i < xs.length; i++ ) {
			int min = i;
			for(int j = i + 1; j < xs.length; j++ ) {
				if( xs[j].compareTo( xs[min] ) < 0 ) {
					min = j;
				}
			}
			T tmp = xs[min];
			xs[min] = xs[i];
			xs[i] = tmp;
		}
	}
}