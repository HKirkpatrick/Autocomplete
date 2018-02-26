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
    public Term[] allMatches(String prefix)
    {
        
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)
    {
        
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        
    }
}
