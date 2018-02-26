/******************************************************************************
 *  Name:    Hudson Kirkpatrick
 *  NetID:   hbk
 *  Precept: P05B
 *
 *  Partner Name:    Adam Hazelton
 *  Partner NetID:   adameh
 *  Partner Precept: P04B
 *
 *  Description:  Blah
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchDeluxe
{
    // Returns the index of the first key in a[] that equals the search key,
    // or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key,
                                         Comparator<Key> comparator)
    {
        if (a == null || key == null || comparator == null)
        {
            throw new IllegalArgumentException();
        }
        int hi = a.length - 1, lo = 0, mid;
        while (hi >= lo)
        {
            mid = lo + (hi - lo)/2;
            int comp = comparator.compare(key, a[mid]);
            if (comp < 0)
                hi = mid - 1;
            else if (comp > 0)
                lo = mid + 1;
            else if (mid == lo)
                return mid;
            else
                hi = mid;
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key
    // or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key,
                                        Comparator<Key> comparator)
    {
        if (a == null || key == null || comparator == null)
        {
            throw new IllegalArgumentException();
        }
        int hi = a.length - 1, lo = 0, mid;
        while (hi >= lo) {
            mid = lo + (hi - lo + 1)/2;
            int comp = comparator.compare(key, a[mid]);
            if (comp < 0)
                hi = mid - 1;
            else if (comp > 0)
                lo = mid + 1;
            else if (mid == hi)
                return mid;
            else
                lo = mid;
        }
        return -1;
    }

    
    // Unit testing
    public static void main(String[] args)
    {
        int size = 10;
        Integer[] a = new Integer[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(i);
        }
        
        // Testing firstIndexOf()
        for (int i = 0; i < a.length; i++) {
            int index = firstIndexOf(a, Integer.valueOf(i), Comparator.naturalOrder());
            if (!a[index].equals(Integer.valueOf(i))) {
                StdOut.printf("ERROR: firstIndexOf found %d at %d.", i, index);
            }
        }
        
        // Testing lastIndexOf()
        for (int i = 0; i < a.length; i++) {
            int index = lastIndexOf(a, Integer.valueOf(i), Comparator.naturalOrder());
            if (!a[index].equals(Integer.valueOf(i))) {
                StdOut.printf("ERROR: lastIndexOf found %d at %d/", i, index);
            }
        }
        
        size = 12;
        a = new Integer[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(i / 3);
        }
        
        // Testing lastIndexOf()
        for (int i = 0; i < a.length; i++) {
            int index = lastIndexOf(a, Integer.valueOf(i/3),
                                    Comparator.naturalOrder());
            if (!a[index].equals(Integer.valueOf(i/3))) {
                StdOut.printf("ERROR: lastIndexOf found %d at %d/", i/3, index);
            }
        }
        
        // Testing lastIndexOf()
        for (int i = 0; i < a.length; i++) {
            int index = lastIndexOf(a, Integer.valueOf(i/3),
                                    Comparator.naturalOrder());
            if (!a[index].equals(Integer.valueOf(i/3))) {
                StdOut.printf("ERROR: lastIndexOf found %d at %d/", i/3, index);
            }
        }
    }
}
