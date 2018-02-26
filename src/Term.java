import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

public class Term implements Comparable<Term>
{
    // query string
    private final String query;
    
    // weight
    private final long weight;
    
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight)
    {
        if (query == null || weight < 0)
            throw new IllegalArgumentException();
        
        this.query = query;
        this.weight = weight;
    }
    
    // ReverseWeightOrder class
    private static class ReverseWeightOrder implements Comparator<Term>
    {
        public int compare(Term o1, Term o2)
        {
            if (o1.weight < o2.weight)
                return 1;
            else if (o1.weight > o2.weight)
                return -1;
            else
                return 0;
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder()
    {
        return new ReverseWeightOrder();
    }
    
    // PrefixOrder class
    private static class PrefixOrder implements Comparator<Term>
    {
        public final int r;
        
        public PrefixOrder(int r)
        {
            this.r = r;
        }
        
        public int compare(Term o1, Term o2)
        {
            for(int i = 0; i < r && i < o1.query.length() && i < o2.query.length(); i++)
            {
                if (o1.query.charAt(i) < o2.query.charAt(i))
                    return -1;
                else if (o1.query.charAt(i) > o2.query.charAt(i))
                    return 1;
            }
            if(o1.query.length() < o2.query.length() && o1.query.length() < r)
                return -1;
            else if(o2.query.length() < o1.query.length() && o2.query.length() < r)
                return 1;
            else
                return 0;
        }
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r)
    {
        if (r < 0)
        {
            throw new IllegalArgumentException();
        }
        
        return new PrefixOrder(r);
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that)
    {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString()
    {
        return weight + "\t" + query;
    }

    // unit testing
    public static void main(String[] args)
    {
        Term t1 = new Term("Hello",10);
        Term t2 = new Term("Help me",5);
        StdOut.println(byReverseWeightOrder().compare(t1,t2));
        StdOut.println(byPrefixOrder(5).compare(t1,t2));
        StdOut.println(t1.compareTo(t2));
        StdOut.println(t1.toString());
    }
}
