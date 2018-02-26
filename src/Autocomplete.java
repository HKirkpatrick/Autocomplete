import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Autocomplete {
    private final Term[] terms;
    
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms)
    {
        if(terms == null)
        {
            throw new IllegalArgumentException();
        }
        this.terms = terms;
        Arrays.sort(terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        int r = prefix.length();
        Term p = new Term(prefix, 0);
        int i = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(r));
        int size = numberOfMatches(prefix);
        Term[] matches = new Term[size];
        for(int j = 0; j < size; j++) {
            matches[j] = terms[i++];
        }
        return matches;
    }
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        int r = prefix.length();
        int start, end;
        Term p = new Term(prefix, 0);
        start = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(r));
        StdOut.println(start);
        if (start < 0)
            return 0;
        end = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(r));
        StdOut.println(end);
        return end - start + 1;
    }

    // unit testing
    public static void main(String[] args)
    {
        Term[] terms = {new Term("testing",10), new Term("testing more",5),
                        new Term("testing still",2), new Term("not testing",4)};
        Autocomplete a = new Autocomplete(terms);
        Term[] t = a.allMatches("test");
        StdOut.println(a.numberOfMatches("test"));
        for (Term term : t)
        {
            StdOut.println(term);
        }
    }
}
