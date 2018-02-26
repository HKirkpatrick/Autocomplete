/******************************************************************************
 *  Name: Adam Hazelton
 *  NetID: adameh
 *  Precept: P04B  
 *
 *  Partner Name: Hudson Kirkpatrick       
 *  Partner NetID: hbk      
 *  Partner Precept: P05B    
 *
 *  Hours to complete assignment (optional): 3
 *	
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  to find the first index of a key that equals the search key.
 *****************************************************************************/
It binary searches the array until it finds an index 'I' such that array[I - 1]
is less than array[I], and array[I] equals the key passed in. If I equals 0,
then arr[I] must be the first occurence (assuming the array is correctly
sorted).

/******************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 *****************************************************************************/

Autocomplete() :
We used Arrays.sort(), which uses mergesort for arrays of objects (Strings
in our case).
allMatches() :
We also used Arrays.sort() for this.
numberOfMatches() :
Number of matches doesn't use any sorting algorithm; it just finds the first
occurence of the prefix and the last, and returns the difference of their
integers. It calls firstIndexOf and lastIndexOf, which both use binary search.
/******************************************************************************
 *  What is the order of growth of the number of compares (in the worst case)
 *  that each of the operations in the Autocomplete data type make, as a
 *  function of the number of terms n and the number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

Autocomplete():
Arrays.sort() runs mergesort, and guarantees O(nlogn) runtime
worst case.

allMatches():
allMatches() also uses Arrays.sort(), and guarantees O(nlogn) runtime
worst case.

numberOfMatches():
Our implementation uses a form of quicksearch, which runs in
O(logn) worst case.

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
None.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
None

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
None

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
We followed the protocol. We worked on all the parts together, concurrently
on separate computers through git.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
None. Enjoyed it!
  

