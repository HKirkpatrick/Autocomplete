public class Autocomplete {

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms)

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
		int r = prefix.length;
		int i = BinarySearchDeluxe.firstIndexOf(terms, prefix, Terms.byPrefixOrder(r));
		int size = numberOfMatches(prefix);
		Term[] matches = new Term[size];
		for(; i < size; i++) {
			matches[i] = terms[i];	
		}	
		return matches;
	}
    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
		int r = prefix.length;
		int start, end;

		start = BinarySearchDeluxe.firstIndexOf(terms, prefix, Terms.byPrefixOrder(r));	
		end = BinarySearchDeluxe.lastIndexOf(terms, prefix, Terms.byPrefixOrder(r));
		if (start < 0 || end < 0) {
			return 0;	
		}
		return end - start + 1;
	}
    // unit testing (required)
    public static void main(String[] args)   
}
