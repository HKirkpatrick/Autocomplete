public class Term implements Comparable<Term>
{
    // query string
    public final String query;
    
    // weight
    public final long weight;
    
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight)
    {
        if (query == null || weight < 0)
            throw new IllegalArgumentException();
        
        this.query = query;
        this.weight = weight;
    }
    
    // ReverseWeightOrder class
    private static class ReverseWeightOrder extends Comparator<Term>
    {
        public int compare(Term o1, Term o2)
        {
            return o2.weight - o1.weight;
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder()
    {
        return new ReverseWeightOrder();
    }
    
    // PrefixOrder class
    private static class PrefixOrder extends Comparator<Term>
    {
        public final int r;
        
        public PrefixOrder(int r)
        {
            this.r = r;
        }
        
        public int comparator(Term o1, Term o2)
        {
            return o1.query.substring(0,r).compareTo(o2.query.substring(0,r));
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
        StdOut.println(weight + '\t' + query);
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        
    }
}
