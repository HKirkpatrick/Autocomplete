import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchDeluxe {

	// Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		int hi = a.length - 1;
		int lo = 0;
		int mid;
		while (hi >= lo)
		{
			mid = lo + (hi - lo)/2;
			if (comparator.compare(key, a[mid]) < 0)
				hi = mid - 1;
			else if (comparator.compare(key,a[mid]) > 0)
				lo = mid + 1;
			else if (mid == 0 || comparator.compare(key, a[mid-1]) > 0)
				return mid;
			else
				hi = mid -1;
		}
		return -1;
	}

	// Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		int hi = a.length - 1;
		int lo = 0;
		int mid;
		while (hi >= lo) {
			mid = lo + (hi - lo)/2;
			if (comparator.compare(key, a[mid]) < 0)
				hi = mid - 1;
			else if (comparator.compare(key,a[mid]) > 0)
				lo = mid + 1;
			else if (mid == a.length - 1 || comparator.compare(key, a[mid+1]) < 0)
				return mid;
			else
				lo = mid + 1;
		}
		return -1;
	}

	// Unit testing
	static void main(String[] args)
	{
		int size = 10;
		Integer[] a = new Integer[size];
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.valueof(i);
		}
		// Testing firstIndexOf()
		for(int i = 0; i < a.length; i++) {
			int index = firstIndexOf(a, Integer.valueof(i), Comparator.naturalOrder());
			if(a[index] != Integer.valueof(i) {
				StdOut.printf("ERROR: firstIndexOf found %d at %d.", i, index);
			}
		}
		// Testing lastIndexOf()
		for(int i = 0; i < a.length; i++) {
			int index = lastIndexOf(a, Integer.valueof(i), Comparator.naturalOrder());
			if(a[index] != Integer.valueof(i)) {
				StdOut.printf("ERROR: lastIndexOf found %d at %d/", i, index);
			}
		}
	}
}
}
