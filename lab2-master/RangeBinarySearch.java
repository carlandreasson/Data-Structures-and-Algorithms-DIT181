
import java.util.Comparator;

public class RangeBinarySearch {

    // Returns the index of the *first* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there is no matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
        int lo = 0;
        int hi = a.length - 1; //kolla den
        
        //binary search tills man hittar lägsta
    return bSearchFirstIndex(hi, lo, a, key, comparator,-1);
    }
    public static<T> int bSearchFirstIndex(int hi, int lo, T[] a, T key, Comparator<T> comparator, int result){ //first index of
        if (hi < lo) return result;
        int mid = lo + (hi - lo) / 2;
        int compare = comparator.compare(key, a[mid]);

        if(compare < 0){
            return bSearchFirstIndex(mid-1, lo, a, key, comparator,result);
        }else if(compare>0){
            return bSearchFirstIndex(hi,mid+1, a, key, comparator,result);
        }
        else{
            result = mid;
            return bSearchFirstIndex(mid-1,lo, a, key, comparator,result);
        }
    }


    // Returns the index of the *last* element in `a` that equals the search key,
    // according to the given comparator, or -1 if there are is matching element.
    // Precondition: `a` is sorted according to the given comparator.
    // Complexity: O(log N) comparisons where N is the length of `a`
    public static<T> int lastIndexOf(T[] a, T key, Comparator<T> comparator) {
        int lo = 0;
        int hi = a.length - 1; //kolla den
        
        //binary search tills man hittar lägsta
    return bSearchLastIndex(hi, lo, a, key, comparator,-1);
    }
    public static<T> int bSearchLastIndex(int hi, int lo, T[] a, T key, Comparator<T> comparator, int result){ 
        if (hi < lo) return result;
        int mid = lo + (hi - lo) / 2;
        int compare = comparator.compare(key, a[mid]);

        if(compare < 0){
            return bSearchLastIndex(mid-1, lo, a, key, comparator,result);
        }else if(compare>0){
            return bSearchLastIndex(hi,mid+1, a, key, comparator,result);
        }
        else{
            result = mid;
            return bSearchLastIndex(hi,mid+1, a, key, comparator,result);
        }
    }
}