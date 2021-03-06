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

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Autocomplete {
    // stores the terms
    private final Term[] terms;
    
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms)
    {
        if (terms == null)
        {
            throw new IllegalArgumentException();
        }
        this.terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++)
        {
            if (terms[i] == null)
            {
                throw new IllegalArgumentException();
            }
            this.terms[i] = terms[i];
        }
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in
    // descending order of weight.
    public Term[] allMatches(String prefix)
    {
        if (prefix == null)
        {
            throw new IllegalArgumentException();
        }
        int r = prefix.length();
        int i = BinarySearchDeluxe.firstIndexOf(terms,
                                                new Term(prefix, 0),
                                                Term.byPrefixOrder(r));
        int size = numberOfMatches(prefix);
        Term[] matches = new Term[size];
        for (int j = 0; j < size; j++) {
            matches[j] = terms[i++];
        }
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }
    
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null)
        {
            throw new IllegalArgumentException();
        }
        int r = prefix.length();
        int start, end;
        Term p = new Term(prefix, 0);
        start = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(r));
        if (start < 0)
            return 0;
        end = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(r));
        return end - start + 1;
    }

    // unit testing
    public static void main(String[] args)
    {
        Term[] terms = {new Term("testing", 10), new Term("testing more", 5),
                        new Term("testing still", 2), new Term("not testing", 4)};
        Autocomplete a = new Autocomplete(terms);
        StdOut.println(a.numberOfMatches("test"));
        Term[] t = a.allMatches("test");
        for (Term term : t)
        {
            StdOut.println(term);
        }
    }
}
