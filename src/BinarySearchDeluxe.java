public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int hi = a.length - 1;
        int lo = 0;
        int mid;
        while(hi >= lo) {
            mid = lo + (hi - lo)/2;
            if(comparator.compare(key, a[mid]) < 0) {
                hi = mid - 1;
            }
            else if(key > a[mid]) {
                lo = mid + 1;
            }
            else {
                if(comparator.compare(key, a[mid]) < 0) {
                    
                }
                

            }
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)

    // unit testing (required)
    public static void main(String[] args)   
}
