import java.util.Arrays;

public class Autocomplete {
    private Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N) where N is the number of dictionary terms
    private void sortDictionary() {
        Arrays.sort(dictionary,Term.byLexicographicOrder);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N + M log M) where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        // TODO
        Term searchTerm = new Term(prefix,0);
        int first = RangeBinarySearch.firstIndexOf(dictionary,searchTerm,Term.byPrefixOrder(prefix.length())); // O(log(n))
        int last = RangeBinarySearch.lastIndexOf(dictionary,searchTerm,Term.byPrefixOrder(prefix.length())); // O(log(n))
        if(first < 0 && last < 0){
            return new Term[0];
        }
        Term[] a = new Term[last-first+1];
        int count = 0;
        //int i = first;
        for(int i = first;i<=last;i++,count++){ //(m)
            a[count]=dictionary[i];
        }
        Arrays.sort(a,Term.byReverseWeightOrder); // O(log(n))
        return a;
    }

    // Returns the number of terms that start with the given prefix.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N) where N is the number of dictionary terms
    public int numberOfMatches(String prefix) {
        Term searchTerm = new Term(prefix,0);
        int first = RangeBinarySearch.firstIndexOf(dictionary,searchTerm,Term.byPrefixOrder(prefix.length()));
        int last = RangeBinarySearch.lastIndexOf(dictionary,searchTerm,Term.byPrefixOrder(prefix.length()));
        if(first < 0 && last < 0){
            return 0;
        }
        return (last-first)+1;
    }

}
